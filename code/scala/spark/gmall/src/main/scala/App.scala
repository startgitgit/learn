import java.lang
import java.text.SimpleDateFormat
import java.util.Date

import com.alibaba.fastjson.{JSON, JSONObject}
import model.DauInfo
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.TopicPartition
import org.apache.spark.{SparkConf, TaskContext}
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.{DStream, InputDStream}
import org.apache.spark.streaming.kafka010.{HasOffsetRanges, OffsetRange}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import redis.clients.jedis.Jedis
import utils.{MyKafkaUtil, OffsetManager, RedisUtil}

import scala.collection.mutable.ListBuffer

/**
 * @author zhouyq
 * @date 2020/12/15 19:43
 * @version 1.0
 */
object App {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("dau_app")
    val ssc = new StreamingContext(sparkConf, Seconds(5))
    val groupId = "GMALL_DAU_CONSUMER"
    val topic = "GMALL_START"

    //从redis读取偏移量
    val startupOffsets: Map[TopicPartition, Long] = OffsetManager.getOffset(groupId, topic)

    // val startupInputDstream: InputDStream[ConsumerRecord[String, String]] = MyKafkaUtil.getKafkaStream(topic, ssc)
    //根据偏移起始点获得数据
    val startupInputDstream: InputDStream[ConsumerRecord[String, String]] = MyKafkaUtil.getKafkaStream(topic, ssc, startupOffsets, groupId)

    //获得偏移结束点
    var startupOffsetRanges: Array[OffsetRange] = Array.empty[OffsetRange]
    val startupInputGetOffsetDstream: DStream[ConsumerRecord[String, String]] = startupInputDstream.transform { rdd =>
      startupOffsetRanges = rdd.asInstanceOf[HasOffsetRanges].offsetRanges
      rdd
    }

    val startLogInfoDStream: DStream[JSONObject] = startupInputGetOffsetDstream.map { record =>
      val startupJson: String = record.value()
      val startupJSONObj: JSONObject = JSON.parseObject(startupJson)
      val long: lang.Long = startupJSONObj.getLong("ts")
      startupJSONObj
    }
    startLogInfoDStream.print(100)

    val dauLoginfoDstream: DStream[JSONObject] = startLogInfoDStream.transform { rdd =>
      println("前：" + rdd.count())
      val logInfoRdd: RDD[JSONObject] = rdd.mapPartitions { startLogInfoItr =>
        val jedis: Jedis = RedisUtil.getJedisClient
        val dauLogInfoList = new ListBuffer[JSONObject]
        val startLogList: List[JSONObject] = startLogInfoItr.toList

        for (startupJSONObj <- startLogList) {
          val ts: lang.Long = startupJSONObj.getLong("ts")
          val dt: String = new SimpleDateFormat("yyyy-MM-dd").format(new Date(ts))
          val dauKey = "dau:" + dt
          val ifFirst: lang.Long = jedis.sadd(dauKey, startupJSONObj.getJSONObject("common").getString("mid"))
          if (ifFirst == 1L) {
            dauLogInfoList += startupJSONObj
          }
        }
        jedis.close()
        dauLogInfoList.toIterator
      }
      // println("后：" + logInfoRdd.count())
      logInfoRdd
    }


    val dauDstream: DStream[DauInfo] = dauLoginfoDstream.map { startupJsonObj =>
      val dtHr: String = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(startupJsonObj.getLong("ts")))
      val dtHrArr: Array[String] = dtHr.split(" ")
      val dt = dtHrArr(0)
      val timeArr = dtHrArr(1).split(":")
      val hr = timeArr(0)
      val mi = timeArr(1)
      val commonJSONObj: JSONObject = startupJsonObj.getJSONObject("common")
      DauInfo(commonJSONObj.getString("mid"), commonJSONObj.getString("uid"), commonJSONObj.getString("mid"), commonJSONObj.getString("ch")
        , commonJSONObj.getString("vc"), dt, hr, mi, startupJsonObj.getLong("ts"))
    }

    dauDstream.foreachRDD { rdd =>
      rdd.foreachPartition { dauInfoItr =>

        ///可以观察偏移量
        if (startupOffsetRanges != null && startupOffsetRanges.size > 0) {
          val offsetRange: OffsetRange = startupOffsetRanges(TaskContext.get().partitionId())
          println("from:" + offsetRange.fromOffset + " --- to:" + offsetRange.untilOffset)
        }

        val dauInfoWithIdList: List[(String, DauInfo)] = dauInfoItr.toList.map(dauInfo => (dauInfo.dt + "_" + dauInfo.mid, dauInfo))
        val dateStr: String = new SimpleDateFormat("yyyyMMdd").format(new Date())
        //        MyEsUtil.bulkInsert(dauInfoWithIdList, "gmall_dau_info_" + dateStr)
      }
      //在保存时最后提交偏移量

      OffsetManager.saveOffset(groupId, topic, startupOffsetRanges)

    }


    ssc.start()
    ssc.awaitTermination()
  }

}
