object Ex9 extends App {

  def compose[A, B, C](f: A => B, g: B => C)(r: A): C = {
    g(f(r))
  }

  val pi:Double = 3.14
  val f = {r: Int => 2 * pi * r}
  val g = {y: Double => s"The lenght of the circle is $y"}

  val l = compose(f, g)_

  println("Enter value for radius:")
  val r = scala.io.StdIn.readInt()
  println(l(r))
}
