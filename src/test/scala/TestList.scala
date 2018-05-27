
/**
  * Created by:wentuanxu 
  * date: 2018/5/24.
  */
object TestList {
  def main(args: Array[String]): Unit = {
    val list = List("1", "2", "3")

    val str = list2String(list)
    println(str)

  }

  // 这里也是将 list 看成 首字母加上其余部分
  def list2String(list: List[String]): String = list match {
    case s :: rest => s + " " + list2String(rest)
    case Nil => ""
  }
}
