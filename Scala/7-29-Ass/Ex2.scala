object Ex2 {

  val sum: (Int) => Int = (n) => {
    (n* (n + 1)) / 2
  }

  def main(args: Array[String]): Unit = {
    println("Enter value for n:")
    val n = scala.io.StdIn.readInt()

    val res = sum(n)

    println(s"The sum of numbers from 0 to $n is: $res")
  }
}