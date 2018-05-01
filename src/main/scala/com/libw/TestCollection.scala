package com.libw

/**
  * Created by:wentuanxu 
  * date: 2018/4/30.
  */
object TestCollection {
  def main(args: Array[String]): Unit = {
    // 1. 使用 foreach 遍历一个集合
    val x = Vector(1, 2, 3)
    x.foreach(println) // 因为 scala 会自动进行类型推导，所以，直接println 和 下面的结果是一样的
    x.foreach((i: Int) => println(i))
    x.foreach((i: Int) => {
      println(i)
    })
    x.foreach(i => println(i))
    x.foreach(println(_)) // 还可以使用下划线通配符简化表达式

    // 2. map的遍历

    val map = Map("hello" -> "world", "hello2" -> "world2")
    map.foreach {
      case (k, v) => {
        println(k + "," + v)
      }
    }

    // 对于上面map的遍历case 中的(k,v) 只是一个类似形参的东西，可以使用任何名称,例如下面使用 hello,world
    map.foreach {
      case (hello, world) => {
        println(hello + "," + world)
      }
    }

    // 3. 使用for 循环去遍历一个 集合 // 只要是 Traversable类型的都可以使用 for 遍历
    for (f <- x) {
      println(f)
    }


    val fruits = Array("apple", "orange", "banana")
    for (f <- fruits) {
      val s = f.toUpperCase
      println(s)
    }

    // 如果想获取到 fruits 数组的下标可以使用 zipWithIndex,或者传统的size 方式
    for ((f, i) <- fruits.zipWithIndex) {
      println(i + "," + f)
    }

    for (i <- 0 until fruits.size) {
      println(i + "," + fruits(i))
      println(s"fruits i: $i is ${fruits(i)}")
    }

    // 另外在使用 fruits.zipWithIndex 时，如果fruits 数组很大，可以使用 view，
    // 使用view会在 用到的时候才去初始化 fruits的原始数据。 比如fruits来源于db之类
    for ((f, i) <- fruits.view.zipWithIndex) {
      println(i + "," + f)
    }

    // 4. 使用 for/yield 生成另外一个集合
    val newFruits = for (e <- fruits) yield e.toUpperCase
    val newFruits2 = for (e <- fruits) yield {
      e.toUpperCase
    }
    println(newFruits)
    println(newFruits2)


    // 5. iterator
    val it = newFruits.iterator
    it.foreach(println)
    it.foreach(println) // iterator 的foreach 操作只会在第一次生效


    // for 表达式中的 守卫条件
    val newFruits3 = for {
      e <- fruits
      if (e.startsWith("a")) // 过滤出fruits 中 startsWith a 的
    } yield e

    newFruits3.foreach(println)

    // 当对集合使用for 而没有yield 时，仅仅是对集合的每个元素进行操作，而for/yield 则是构造一个新的集合
  }
}
