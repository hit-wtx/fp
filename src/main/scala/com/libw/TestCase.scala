package com.libw

/**
  * Created by:wentuanxu 
  * date: 2018/5/13.
  */

case class Person3(name: String, age: Int)

object TestCase {

  def main(args: Array[String]): Unit = {
    println(patternConstant(5))
    println(patternVariable(5))
    println(patternVariable2(50))

    val person = new Person3("wtx", 28)
    patternConstructor(person)

    val list = List("spark", "Hive", "SparkSQL")
    val tuple1 = ("hello", "world", 1)
    println(patternTuple(list))
    println(patternTuple(tuple1)) // 匹配出来tuple 的第一项 "hello"
    println(patterntype(1))


  }

  // 常量匹配
  def patternConstant(x: Any): Any = x match {
    case 1 => "一"
    case true => "真"
    case _ => "other"
  }

  // 变量匹配  其中 if 称之为 守卫条件
  def patternVariable(x: Any) = x match {
    case x if (x == 5) => "x+" + 5
    case x if (x == "scala") => "x+" + x
    case _ =>
  }

  // 对于守卫条件 中 > < 等判断条件时,x 的类型必须是可以比较的类型，比如下面的int
  def patternVariable2(x: Int) = x match {
    case x if (x < 60) => "不及格"
    case x if (x >= 60 && x <= 80) => "及格"
    case x if (x >= 80) => "优秀"
    case _ => ""
  }

  // 构造函数匹配
  def patternConstructor(p: Person3) = p match {
    case Person3(name, age) => println("name=" + name + ",age=" + age)
    case _ =>
  }

  // tuple 匹配
  def patternTuple(t: Any) = t match {
    case (one, _, _) => one
    case _ => "other"
  }

  // 类型匹配
  def patterntype(x: Any) = x match {
    case x: Int => "int"
    case x: String => "String"
    case x: Double => "Double"
    case _ => "other"
  }

  // 另外还有些比较复杂的正则匹配

}
