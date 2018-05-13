package com.libw

/**
  * Created by:wentuanxu 
  * date: 2018/5/13.
  */
object TestEither {
  def main(args: Array[String]): Unit = {
    divideBy(10, 0) match {
      case Left(s) => println("answer:" + s)
      case Right(s) => println("answer:" + s)
    }

    val result = divideBy(10, 0)
    // 除了上面的 match 方式外，还可以使用 比较传统的 判断方式，只是不是很推荐这种方式
    if(result.isLeft){
      println(result.left.get)
    }
  }

  //Scala中有Left,Right两个类，继承于Either,主要用途是表示两个可能不同的类型（它们之间没有交集）,Left主要是表示Failure,Right表示有

  def divideBy(x: Int, y: Int): Either[String, Int] = {
    if (y == 0) Left("can't divide by 0")
    else Right(x / y)
  }
}
