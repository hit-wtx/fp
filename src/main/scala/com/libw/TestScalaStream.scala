package com.libw

/**
  * Created by:wentuanxu 
  * date: 2018/5/12.
  */
object TestScalaStream {
  def main(args: Array[String]): Unit = {
    val stream = (1 to 5).toStream
    println(stream) // Stream(1, ?)
    println(stream.head) //1
    println(stream.tail) // Stream(2, ?)

    stream.map((x: Int) => {
      println("step x:" + x)
      x * 2
    }).foreach(println) // 输出2，4，6，8，10

    (1 to 5).view.map((x: Int) => {
      println("step x:" + x)
      x * 2
    }).foreach(println)


    val xmap = (0 to 5).toStream.map((x: Int) => {
      println(x)
      x * 2
    })

    val xview = (0 to 5).view.map((x: Int) => {
      println(x)
      x * 2
    })

    println(xmap)
    println(xview)
  }
}
