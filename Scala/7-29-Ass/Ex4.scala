object Ex4 {

  def suffix(num: Int): String = {
    if (num % 100 >= 11 && num % 100 <= 13) {
      "th"
    } else {
      num % 10 match {
        case 1 => "st"
        case 2 => "nd"
        case 3 => "rd"
        case _ => "th"
      }
    }
  }

  def main(args: Array[String]): Unit = {
    println("Enter a number: ")
    val num = scala.io.StdIn.readInt()

    val res = suffix(num)
    println(s"The suffix for $num is $res")
  }
}