object Ex15 extends App {
  def update[K, V](m: List[(K, V)], k: K, v:V) = {
    val filtered = m.filterNot(_._1 == k)
    filtered :+ (k -> v)
  }

  val map123 = List((1,"a"),(2,"b"), (3,"c"))
  val res = update(map123, 2, "asdf")
  val res2 = update(map123, 4, "d")

  println(res)
  println(res2)

}
