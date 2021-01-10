package com.zyq.flink

import org.apache.flink.streaming.api.scala._

/**
 * @author zhouyq
 * @date 2021/1/10 20:38
 * @version 1.0
 */
object Keyby {

  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    env.setParallelism(1)
    val inputStream: DataStream[(Int, Int, Int)] = env.fromElements((1, 2, 2), (2, 3, 1), (2, 2, 4), (1, 5, 3))
    val resultStream: DataStream[(Int, Int, Int)] = inputStream.keyBy(0).sum(1)

    resultStream.print()
    env.execute()
  }
}
