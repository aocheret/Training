object Ex7 extends App {
  def boundingBox(shape: Shape): Rectangle = shape match {
    case Circle(r, x, y) =>
      Rectangle(x - r, y - r, 2 * r, 2 * r)

    case rect: Rectangle =>
      rect
  }

  def rectanglesOverlap(r1: Rectangle, r2: Rectangle): Boolean = {
    val r1Right = r1.llx + r1.w
    val r1Top = r1.lly + r1.h
    val r2Right = r2.llx + r2.w
    val r2Top = r2.lly + r2.h

    !(r1.llx >= r2Right || r2.llx >= r1Right || r1.lly >= r2Top || r2.lly >= r1Top)
  }

  def mayOverlap(s1: Shape, s2: Shape): Boolean = {
    val bb1 = boundingBox(s1)
    val bb2 = boundingBox(s2)
    rectanglesOverlap(bb1, bb2)
  }

  val circle1 = Circle(5, 20, 20)
  val circle2 = Circle(3, 8, 8)
  val rectangle1 = Rectangle(2, 3, 4, 5)
  val rectangle2 = Rectangle(5, 7, 4, 5)

  println(s"Do circle1 and circle2 overlap? ${mayOverlap(circle1, circle2)}")
  println(s"Do circle1 and rectangle1 overlap? ${mayOverlap(circle1, rectangle1)}")
  println(s"Do circle2 and rectangle2 overlap? ${mayOverlap(circle2, rectangle1)}")
  println(s"Do rectangle1 and rectangle2 overlap? ${mayOverlap(rectangle1, rectangle2)}")
}

