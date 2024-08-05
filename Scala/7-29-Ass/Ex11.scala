object Ex11 extends App {
  def map[A, B](f: A => B, l: List[A]): List[B] = {
    l match {
      case Nil => Nil
      case head :: tail => f(head) :: map(f, tail)
    }
  }

  val numbers = List(1, 2, 3, 4)
  val doubled = map((x: Int) => x * 2, numbers)
  println(doubled)

}
