package org.itc.com

object Main {

  def sum(n1: Int, n2: Float): Float = {
    n1+n2
  }

  var rate = 80
  def CurToCur(n1: Float): Float = {
    n1*rate
  }

  val sq_func = (n3: Int) => n3*n3
  println(sq_func(2))

  def main(args: Array[String]): Unit = {
    println("Hello world!")
    println( sum(n1 = 10, n2 = 10.20f))

    val fl:Float =3.14f
    var age:Int =2

    val pi:Float =3.14f
    var r:Int =2

    if (age>60){
      println("Senior")

    }
    else
      println("minor")

    for ( i<- 0 to 10)
//      println(i)
      println("Length of the circle with radius of "+ i + " is " + length(pi, i))
  }

  def length(pi:Float, r:Int): Float = {
    2*pi*r
  }
}