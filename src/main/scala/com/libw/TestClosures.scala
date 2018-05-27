package com.libw

/**
  * Created by:wentuanxu 
  * date: 2018/5/28.
  */
object TestClosures {

  def main(args: Array[String]): Unit = {
    // 这里举个例子是说,假设公司要发年终奖，
    // 每个部门的系数是不同的，part1 是10000,part2 是20000,part3 是30000
    // 除了部门自己的系数外，还有个人的系数。
    def part1 = add(10000)

    def part2 = add(20000)

    def part3 = add(30000)

    println(part1(1000))
    println(part2(3000))
    println(part3(5000))

    var wages = 40000

    def part4 = add(wages) //

    println(part4.getClass) //com.libw.TestClosures$$anonfun$add$1
    println(part4(4000)) //44000

    wages = 50000
    println(part4(4000)) //54000 尽管wages 变量的变化超出了part4 函数的有效作用域,函数part4 还是能够感知到这个变化


    // 部分应用函数
    val sum = (a: Int, b: Int, c: Int) => a + b + c
    // 定义一个函数，接收3个参数,返回3个参数之和
    // 部分应用函数只是在“已有函数”的基础上，提供部分默认参数，未提供默认参数的地方使用下划线替代，从而创建出一个“函数值”
    val f: Int => Int = sum(10, 10, _: Int) // f 是一个函数，返回值为 Int=>Int 的函数，接收一个int 形式的参数
    println(f(10))
    println(f(30))
    val f2: Int => Int = sum(_: Int, 30, 50)
    println(f2(20))
    println(f2(120))

    // 柯里化函数
    // 柯里化指的是将原来接受多个参数的函数变成新的接受一个参数的函数的 过程
    // 柯里化 是一个过程，部分应用(部分施用)函数式一个部分提供默认值，将函数"化简"的过程
    def sum2(a: Int)(b: Int) = a + b

    def sum3 = sum2(10)(_)

    println(sum2(10)(10))
    println(sum3.getClass) // $anonfun$sum3$1$1
    println(sum3(10))

  }

  /*
    闭包
    1. 函数在变量不处于其有效作用域时，还能对变量进行访问
    2. 闭包 = 代码 + 用到的非局部变量
  */
  def add(bonus: Int) = (wages: Int) => wages + bonus

}
