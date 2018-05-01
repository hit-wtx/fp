package com.libw

import java.util

import scala.collection.mutable

/**
  * Created by:wtx
  * date: 2018/4/30.
  */

class PersonOp(val name: String, val age: Int) {
  override def toString: String = name + "," + age
}

object TestCollectionOp {
  def main(args: Array[String]): Unit = {
    val list1 = List(1, 2, 3)
    val list2 = List(4, 5, 6)

    val list3 = list1 ++ list2 // 1
    val list4 = list1 ++: list2 // 2
    val list5 = list2.++:(list1) // 3
    val list6 = list2.:::(list1) // 4

    // 上面的 2，3，4 与1 的实现目的相同，这些操作符 都是函数，类似于c++ 中的运算符重载
    // 比如++ 的函数声明如下：
    //  override def ++[B >: A, That](that : scala.collection.GenTraversableOnce[B])(implicit bf : scala.collection.generic.CanBuildFrom[scala.collection.immutable.List[A], B, That]) : That = { /* compiled code */ }

    println(list3) // List(1, 2, 3, 4, 5, 6)
    println(list4) // List(1, 2, 3, 4, 5, 6)
    println(list5) // List(1, 2, 3, 4, 5, 6)
    println(list6) // List(1, 2, 3, 4, 5, 6)

    //2.  map 集合
    val javaMap = new util.HashMap[String, String]()
    javaMap.put("hello", "world")
    println(javaMap)
    var scalaMap: mutable.HashMap[String, AnyRef] = new mutable.HashMap[String, AnyRef]()
    scalaMap.put("name", "wtx")
    scalaMap.put("sex", "male")
    scalaMap.put("age", "28")

    scalaMap += ("ciyt" -> "beijing")
    // scalaMap 的语法对于添加元素,除了类似java 的put外，还可以使用 map +=(key,value),如果是修改的话map(key)=value

    for (v <- scalaMap.keySet) println(v + ":" + scalaMap(v))
    scalaMap("name") = "wtx2"
    for (v <- scalaMap.keySet) println(v + ":" + scalaMap(v))


    // 构造一个空的map，scala.collection.immutable.Map 类型
    val nums: Map[Int, Int] = Map()
    println(nums.isEmpty)

    //3. map函数  map 函数会对每一条输入进行指定的操作，然后为每一条输入返回一个对象；
    //  而flatMap函数则是两个操作的集合——正是“先映射后扁平化”。

    val list7 = list1.map(x => x + 1)
    list7.foreach(println)
    val list8 = list1.map(x => new PersonOp("wtx", x))
    list8.foreach(println)


    val list9 = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))

    println(list9.flatMap(x => x)) // List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(list9.flatMap(x => x.map(_ * 2))) // List(2, 4, 6, 8, 10, 12, 14, 16, 18)
    // x.map(_ * 2) 是说 给每个x（list）*2 ,然后在 flat（拍平）
    // 可以理解为先映射后扁平化

    //  for
    val fori = for (i <- 1 to 10 if i > 5) print(i) // 卫语句

    val fori2 = for {
      i <- 1 to 10
      if (i > 10)
    } yield i

    println(fori)
    println(fori2)

    val isLengthBigThan3 = if (list9.size > 3) true else false
    println(isLengthBigThan3)
  }
}
