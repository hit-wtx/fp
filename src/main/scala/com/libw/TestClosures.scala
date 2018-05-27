package com.libw

/**
  * Created by:wentuanxu 
  * date: 2018/5/28.
  */
object TestClosures {

  def main(args: Array[String]): Unit = {
    def part1 = add(10000)

    def part2 = add(20000)

    def part3 = add(30000)

    println(part1(1000))
    println(part2(3000))
    println(part3(5000))

    var wages = 40000

    def part4 = add(wages) //

    println(part4.getClass)//com.libw.TestClosures$$anonfun$add$1
    println(part4(4000)) //44000

    wages = 50000
    println(part4(4000)) //54000 尽管wages 变量的变化超出了part4 函数的有效作用域,函数part4 还是能够感知到这个变化
  }

  /*
    闭包
    1. 函数在变量不处于其有效作用域时，还能对变量进行访问
    2. 闭包 = 代码 + 用到的非局部变量
  */
  def add(bonus: Int) = (wages: Int) => wages + bonus
}
