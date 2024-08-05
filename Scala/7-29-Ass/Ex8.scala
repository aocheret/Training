object Ex8 extends App {

  def compose1[A, B, C](f: A => B, g: B => C)(r: A): C = {
    g(f(r))
  }

  val pi:Double = 3.14
  def f(r: Int): Double = 2 * pi * r
  def g(y: Double): String = s"The lenght of the circle is $y"

  val l = compose1(f, g)_

  println("Enter value for radius:")
  val r = scala.io.StdIn.readInt()
  println(l(r))
}
