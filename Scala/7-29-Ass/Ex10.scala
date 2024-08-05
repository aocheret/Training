object Ex10 extends App {

  def compose[A, B, C](f: A => B, g: B => C)(x: A): C = {
    g(f(x))
  }

  val e1: Int => String = (x: Int) => s"Number is $x"
  val e2: String => Boolean = (s: String) => s.contains("Number")

  // Valid
  val res = compose(e1, e2)_
  println(res(5))

  // Invalid
//  val res2 = compose(e2, e1)_
//  println(res2(5))

}
