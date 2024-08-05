import scala.collection.immutable.ListMap

object Ex20 extends App{
  def election(votes: List[String]): ListMap[String,Int] = {
    votes.foldLeft(ListMap.empty[String, Int]) { (map, vote) =>
      if (map.contains(vote)) {
        map + (vote -> (map(vote) + 1))
      } else {
        map + (vote -> 1)
      }

    }
  }
  val votes = List("Hillary", "Donald", "Hillary")
  val res = election(votes)

  print(res)
}
