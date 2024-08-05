object Ex13 extends App {
  def reverse[A](l: List[A]): List[A] = {
    l match {
      case Nil => Nil
      case head :: tail => reverse(tail) :+ head
    }
  }

  val numbers = List(1, 2, 3, 4, 5)
  val reversedNumbers = reverse(numbers)
  println(reversedNumbers)

}
