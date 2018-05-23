package com.libw

/**
  * Created by:wentuanxu 
  * date: 2018/5/22.
  */
object TestMapCollect {
  def main(args: Array[String]): Unit = {
    val m = Map("hello" -> "world",
      "hello1" -> "world1",
      "hello2" -> "world2")

    val list = m map {
      case (_, v) => "hi," + v
    } toList

    for ((k, v) <- m) {
      println("k:" + k + ",v:" + v)
    }

    val comM = Map("a" -> List(1,2,3,4),"b" -> List(3,4,5,6))


    comM.map {
      case (k,v) => {
        println("k:" + k + ",v:" + v)
      }
    }


    println(list) // List(hi,world, hi,world1, hi,world2)

    val list2 = m collect {
      case (_, v) => "hi," + v
    } toList

    println(list2) //List(hi,world, hi,world1, hi,world2)


    //List(1, 3, 5, "seven") map { case i: Int => i + 1 } // Exception in thread "main" scala.MatchError: seven (of class java.lang.String)

    val list3 = List(1, 3, 5, "seven") collect { case i: Int => i + 1 } toList

    println(list3) //List(2, 4, 6)

    /*
      这里为什么 类似的代码map抛出异常，而collect 正常运行，因为collect 还另外接收一个PartialFunction 偏函数
    def map[B](f: (A) ⇒ B): List[B]
    def collect[B](pf: PartialFunction[A, B]): List[B]
     */

    /*
      case语句其实是偏函数定义的语法糖，当我们编写一个case语句时，其实等同于创建了一个具有apply与isDefineAt方法的偏函数对象

      def collect[B, That](pf: PartialFunction[A, B])(implicit bf: CanBuildFrom[Repr, B, That]): That = {
          val b = bf(repr)
          for (x <- this) if (pf.isDefinedAt(x)) b += pf(x)
          b.result
    }
    看 collect 的实现，其中isDefinedAt 可以这么理解，相当于我们高中时候学到数学里面的f(x) x的定义域，
    只有在定义域中的值才可以执行f() 函数，非定义域中的值就直接忽略，而map不行，直接报错MatchError
     */


    val list4 = List(1, 2, 3, 4)
    val list5 = list4.toStream.toList
    println(list5)

    val list6 = list4.map(i => i + 1)
    val list7 = list4 map { i => i + 1 }
    println(list6)
    println(list7)
  }
}
