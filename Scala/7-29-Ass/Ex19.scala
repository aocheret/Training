import scala.collection.immutable.ListMap

object Ex19 extends App {
  def list2map[K,V](l: List[(K,V)]): ListMap[K,V] = {
    ListMap(l:_*)
  }

  val map12 = scala.collection.immutable.ListMap(1 -> "a", 2 -> "b").toList
  val map = list2map(map12)

  println(map)
}
