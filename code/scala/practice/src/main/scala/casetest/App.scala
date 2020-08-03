package casetest

/**
 * @author zhouyq
 * @date 2020/8/3 19:38
 * @version 1.0
 */
object App {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 4, 5, 6)
    arr.foreach {
      case 1 => println(1)
      case 2 => println(2)
      case _ => println("Other")
    }

  }
}