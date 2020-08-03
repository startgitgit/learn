package com.practice.functiontest

/**
 * @author zhouyq
 * @date 2020/8/3 22:45
 * @version 1.0
 */
object App {
  def main(args: Array[String]): Unit = {
    /**
     * 1，函数和变量一样作为Scala语言的一等公民，函数可以直接赋值给变量；
     */
    def hi(name:String): Unit ={
      println(name)
    }

    // 将方法转为函数
    val sayhi = hi _
    sayhi("china")



    /**
     * 2, 函数更长用的方式是匿名函数，定义的时候只需要说明输入参数的类型和函数体即可，不需要名称，但是如果你要使用的话，一般会把这个
     * 匿名函数赋值给一个变量（其实是val常量），Spark源码中大量存在这种语法，必须掌握；
     */
    val f = (name: String) => {
      println("hello:" + name)
    }

    f("world")

    /**
     * * 3, 函数可以作为参数直接传递给函数，这极大的简化的编程的语法，为什么这样说呢？原因非常简单：
     * 第一：以前Java的方式是new出一个接口实例，并且在接口实例的回调方法callback中来实现业务逻辑，现在是直接把回调方法
     * callback传递给我的函数，且在函数体中直接使用，这毫无疑问的简化的代码的编写，提升了开发效率；
     * 第二：这种方式非常方便编写负责的业务逻辑和控制逻辑，对于图计算、机器学习、深度学习等而言至关重要；
     *
     * 函数作为函数的参数传递的编程方式是称之为高阶函数的编程方式，Spark源码和应用程序开发中至少60%都是这种代码，必须务必一定要掌握。
     */

    def getName(func: (String) => Unit, name: String): Unit = {
      func(name);
    }

    getName(f, "zhou");


    /**
     * 4, 函数式编程一个非常强大的地方之一在于函数的返回值可以是函数，当函数的返回类型是函数的时候，这个时候就表明Scala的函数实现了闭包！
     * Scala闭包的内幕是：Scala的函数背后是类和对象，所以，Scala的参数都作为了对象的成员！！！！！！，所以后续可以继续访问，这就是Scala
     * 实现闭包的原理内幕！
     **/
    def funcResult(message: String) = (name: String) => println(message + ":" + name)

    funcResult("hello")("scala")
  }

}
