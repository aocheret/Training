object Ex14 extends App {
  def lookup[K, V](m: List[(K, V)], k: K): V = {
    m.find(_._1 == k) match {
      case Some((_, v)) => v
      case None => throw new NoSuchElementException(s"Key $k not found")
    }
  }

  val map123 = List((1,"a"),(2,"b"), (3,"c"))
  val res = lookup(map123, 2)

  println(res)

}
