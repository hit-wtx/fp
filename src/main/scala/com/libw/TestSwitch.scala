package com.libw

import scala.annotation.switch

/**
  * Created by:wentuanxu 
  * date: 2018/5/24.
  */
object TestSwitch {
  def main(args: Array[String]): Unit = {
    val Constant = 'Q'

    // https://www.scala-lang.org/api/current/scala/annotation/switch.html
    // 使用@switch
    def tokenMe(ch: Char) = (ch: @switch) match {
      case ' ' | '\t' | '\n' => 1
      case 'A' | 'Z' | '$' => 2
      case '5' | Constant => 3 // a non-literal may prevent switch generation: this would not compile
      case _ => 4
    }

    val c = tokenMe(Constant)
    println(c)
  }
}
