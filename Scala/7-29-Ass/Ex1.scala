object Ex1 {

  val p: (Int, Int) => Int = (x, y) => {
    x * x + 2 * x * y + y * y * y - 1
  }

  def main(args: Array[String]): Unit = {
    println("Enter value for x:")
    val x = scala.io.StdIn.readInt()

    println("Enter value for y:")
    val y = scala.io.StdIn.readInt()

    val res = p(x, y)

    println(s"For given x and y of $x and $y the value of this polynomial is $res")
  }
}