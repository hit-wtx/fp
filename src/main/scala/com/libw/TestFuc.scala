package com.libw

/**
  * Created by:wentuanxu 
  * date: 2018/5/1.
  */
object TestFuc {
  def main(args: Array[String]): Unit = {
    // 1. 将 函数  (str1: String, str2: String) => str1 + "," + str2 赋值给一个变量 addFuc
    val addFuc = (str1: String, str2: String) => str1 + " " + str2
    println(addFuc("hello", "world"))

    // 2. 接收其他函数作为参数的函数，也被称作高阶函数（higher-order function）
    useAddFuc(addFuc, "hello", "world")

    // 3. scala 中的匿名函数
    // Scala定义匿名函数的语法规则就是，(参数名: 参数类型) => 函数体
    // (x: Int) => x % 2 == 0  是一个匿名函数，该函数接收int 类型的形参，返回值 为 boolean
    val list = List(1, 2, 3, 4)
    println(list.filter((x: Int) => x % 2 == 0))
    println(list.filter(x => x % 2 == 0)) // 因为scala 有类型推导，形参x 的类型 Int 可以自动推导出来，故可以省略
    println(list.filter(_ % 2 == 0)) // 如果参数只有一个，可以使用 _ 表示，更加简化了而已


    val list2 = list.map((num: Int) => num * num) // map 函数接收一个函数
    println(list2.mkString(","))
  }

  // 2. 将函数作为参数使用
  // useAddFuc 接收3个参数, 形参 f,str1,str2
  // 其中 f 的 "类型" (String, String) => String
  def useAddFuc(f: (String, String) => String, str1: String, str2: String) = {
    val result = f(str1, str2)
    println(result)
  }
}
