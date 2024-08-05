import scala.collection.immutable.ListMap

object Ex17 extends App {
  val presidentListMap: ListMap[Int, String] = ListMap(
    41 -> "George H. W. Bush",
    42 -> "Bill Clinton",
    43 -> "George W. Bush",
    44 -> "Barack Obama",
    45 -> "Donald J. Trump",
    46 -> "Joe Biden"
  )

  val last = presidentListMap.keys.max
  println("The current US president is " + presidentListMap(last))
}


