package com.zyq.flink

// 导入一些隐式类型转换，implicit

import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows
import org.apache.flink.streaming.api.windowing.time.Time

object WordCount {
  def main(args: Array[String]): Unit = {
    // 获取运行时环境，类似sparkcontext
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    // 老版本
    //  env.setStreamTimeCharacteristic(TimeCharacteristic.ProcessingTime)
    // 设置分区(并行任务)的数量为1
    //    env.setParallelism(1)
    // 获取建立数据源
    // 需要先启动nc -lk 9999,用来发送数据
    val stream: DataStream[String] = env.socketTextStream("localhost", 9999, '\n')
    // 写对流的转换处理逻辑
    val transformed: DataStream[WordWithCount] = stream
      // 使用空格切分输入的字符串
      .flatMap(line => line.split("\\s"))
      // 类似与mr的map
      .map(w => WordWithCount(w, 1))
      // 使用word字段进行分组，shuffle
      .keyBy(x => x.word)
      //老版本
      //      .keyBy(0)
      //开了一个5s钟的滚动窗口
      .window(TumblingProcessingTimeWindows.of(Time.seconds(10)))
      // 老版本
      //.timeWindow(Time.seconds(5))
      // 针对count字段进行累加操作，类型mr的reduce
      .sum(1)

    // 将计算的结果输出到标准输出
    transformed.print()

    //执行计算逻辑
    env.execute("word count")
  }
}