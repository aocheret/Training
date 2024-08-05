object Ex12 extends App {
  def filter[A](p: A => Boolean, l: List[A]): List[A] = {
    l match {
      case Nil => Nil
      case head :: tail =>
        if (p(head)) head :: filter(p, tail)
        else filter(p, tail)
    }
  }

  val numbers = List(1, 2, 3, 4, 5, 6)
  val evenNumbers = filter((x: Int) => x % 2 == 0, numbers)
  println(evenNumbers)

}
