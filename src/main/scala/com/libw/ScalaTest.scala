package com.libw

/**
  * Created by:wentuanxu 
  * date: 2018/4/29.
  */

class Person(var name: String) {
  override def toString: String = name
}

class Person2(var name: String) extends Ordered[Person2] {
  override def compare(that: Person2): Int = {
    if (this.name == that.name) 0
    else if (this.name > that.name) 1
    else -1
  }
}

object ScalaTest {
  def main(args: Array[String]): Unit = {
    val a = Array("hello", " ", "world")
    println(a.mkString)
    val as = Array(Array("hello"), Array(" "), Array("world"))
    println(as.flatten.mkString) //  对于数组的数组需要 使用 flatten拍平 Array


    val list1 = List(1, 2, 4, 3, 5, 3).sorted
    val list2 = List("sd", "a", "b", "c").sorted
    println(list1)
    println(list2)

    // sortWith 允许使用自定义的排序函数
    println(list1.sortWith(_ < _))
    println(list1.sortWith(_ > _))

    println(list2.sortWith(_.length > _.length))

    // 对于list<Bean> 排序
    var p = new Person("p1")
    var p2 = new Person("p3")
    var p3 = new Person("p2")
    val list3 = List(p, p2, p3)

    var per = new Person2("p1")
    var per2 = new Person2("p3")
    var per3 = new Person2("p2")
    val list4 = List(per, per2, per3)
    println(list3.sortWith(_.name < _.name))
    println(list4.sorted)

    // 元祖的使用
    val t1 = (1, "hello", Array("1"))
    println(t1._1)
    println(t1._2)
    println(t1._3.mkString(","))


    val (a1, a2, a3) = getInfo()
    print(a1)


    val array1 = Array(1, 2, 3, 4, 5)
    val b = array1.view(1, 3)
    println(b)
    val bforce = b.force
    println(bforce.mkString(","))
  }

  // 定义一个 函数（方法） 返回一个tuple
  def getInfo() = {
    (1, 2, 3)
  }
}
