package com.libw

/**
  * Created by:wentuanxu 
  * date: 2018/5/23.
  */
object TestFor {
  def main(args: Array[String]): Unit = {
    // for 和 map 的区别

    // foreach 返回值是 void的,map 的返回值是 $colon$colon
    // foreach 是在遍历集合且不需要返回值的时候使用,而map 是在需要生成一个新的集合时使用。// map用于映射（转换）集合到另一个集合
    // 定义一个函数,实现对于int的x + 1
    val fa = (x: Int) => x + 1

    val l = List(1, 2, 3, 4)
    val ba = l.foreach(fa)
    println(ba.getClass) // void
    val ma = l.map(fa)
    println(ma.getClass) //class scala.collection.immutable.$colon$colon
    ma.foreach(x => print(x + " ")) //2 3 4 5
    println()
    ma.map(x => print(x + " ")) //2 3 4 5
    println()
    val lStr = List("hello", "world", "!", "wtx")

    for (word <- lStr) {
      println(word)
    }

    for {
      word <- lStr
    } yield {
      println(word)
    }

    // for 循环嵌套

    println("=============================")
    for (word <- lStr; c <- word) {
      print(c)
    }
    println()
    println("=============================")
    for (word <- lStr; c <- word; ac = c.toString if (ac != null)) {
      print(ac)
    }
    println()
    println("=============================")

    // for 循环的reduce，可以理解为下面的sumInt 递归调用，在scala 中称之为尾递归（可以优化的一种递归形式）
    // 这里能使用这种递归的原因还是因为: 换个角度看list
    // 比如 (1,2,3,4)，看成 1(head) 和 2,3,4(tail)


    //   另外还有 l.reduceLeft(reduceLeft 方法首先应用于前两个元素，然后再应用于第一次应用的结果和接下去的一个元素，等等，直至整个列表)
    // l.reduceRight
    val sumList = l.reduce((sum, a) => sum + a) // 10
    /*
    def sumInt(n: Int): Int =  { return sumInt(1, n)}
    def sumInt(lastResult: Int, n: Int): Int =  { if (n <= 1)  { return lastResult} return sumInt(n + lastResult, n - 1)}
     */
    println(sumList)
    val sum = List(2, 4, 6).reduceLeft(_ + _) // 12
    println(sum)
    val max = List(1, 4, 9, 6, 7).reduceLeft((x, y) => if (x > y) x else y)
    println(max)


    // for 循环中嵌入卫语句
    for (i <- 0 to 10 if (i % 2 == 0)) println(i)

    /*
        until 和 to关键字
     */
    for (i <- 1 to 3) {
      println("i is " + i);
    }
    for (i <- 1 until 3) {
      println("i is " + i);
    }

  }
}
