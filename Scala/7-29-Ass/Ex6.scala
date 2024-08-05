abstract class Shape

case class Circle(r: Double, x: Double, y: Double) extends Shape
case class Rectangle(llx: Double, lly: Double, w: Double, h: Double) extends Shape

object Ex6 extends App {
  def boundingBox(shape: Shape): Rectangle = shape match {
    case Circle(r, x, y) =>
      Rectangle(x - r, y - r, 2 * r, 2 * r)

    case rect: Rectangle =>
      rect
  }

  val circle = Circle(5, 10, 10)
  val rectangle = Rectangle(2, 3, 4, 5)

  val circleBoundingBox = boundingBox(circle)
  val rectangleBoundingBox = boundingBox(rectangle)

  println(s"The bounding box of the circle is: $circleBoundingBox")
  println(s"The bounding box of the rectangle is: $rectangleBoundingBox")
}
