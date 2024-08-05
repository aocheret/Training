abstract class Colour
case class Red() extends Colour
case class Green() extends Colour
case class Blue() extends Colour
case class Orange() extends Colour

object Ex5 extends App {
  def favouriteColour(c: Colour): Boolean = c match {
    case Red() => false
    case Green() => false
    case Blue() => false
    case Orange() => true
  }

  val myColour1 = Green()
  val myColour2 = Orange()

  // Check if they are your favorite
  println(s"Green? ${favouriteColour(myColour1)}")
  println(s"Orange? ${favouriteColour(myColour2)}")
}
