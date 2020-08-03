package com.practice.casetest

/**
 * @author zhouyq
 * @date 2020/8/3 19:38
 * @version 1.0
 */
object App {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 4, 5, 6)

    //模式匹配
    arr.foreach {
      case 1 => println("==1")
      case _ => println("!=1")
    }

    arr.foreach(x => {println(x)})

    // case class
    val message = Message("xxx", "ttt")
    println(message)

   //偏函数
    val p1:PartialFunction[String, String] = {
      case s if s.contains("1") => s.replace("1", "one")
    }
    val p2:PartialFunction[String, String] = {
      case s if s.contains("2") => s.replace("2", "two")
    }
    val p = p1 andThen p2
    p("12")

  }

  case class Message(sender: String, messageContent: String)

}