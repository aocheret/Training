object Ex16 extends App {
  def keys[K, V](m: List[(K, V)]) = {
    m.map(_._1)
  }

  val map123 = List((1,"a"),(2,"b"), (3,"c"))
  val res = keys(List((1,"a"),(2,"b"), (3,"c")))

  println(res)

}
