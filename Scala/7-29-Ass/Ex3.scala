object Ex3 {

  val cycle: (Int, Int, Int) => (Int, Int, Int) = (a, b, c) => {
    (b, c, a)
  }

  def main(args: Array[String]): Unit = {
    println("Enter three integers separated by spaces (e.g., 1 2 3):")
    val triple = scala.io.StdIn.readLine()

    val parts = triple.split(" ")
    val a = parts(0).toInt
    val b = parts(1).toInt
    val c = parts(2).toInt

    val res = cycle(a, b, c)
    println(s"The final cycle of original of $triple is $res")
  }
}