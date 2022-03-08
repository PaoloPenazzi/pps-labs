package it.unibo.pps

object Es7 extends App{
  enum Shape:
    case Rectangle(width: Double, height: Double)
    case Circle(radius: Double)
    case Square(side: Double)

  object Shape:
    def perimeter(shape: Shape): Double = shape match
      case Rectangle(x, y) => 2 * x + 2 * y
      case Circle(x) => scala.math.Pi * 2 * x
      case Square(x) => 4 * x
    def area(shape: Shape): Double = shape match
      case Rectangle(x, y) => x * y
      case Circle(x) => x * x * scala.math.Pi
      case Square(x) => x * x

  import Shape.*

  val test: Shape = Shape.Rectangle(5, 10)
  println(area(test))     // 50.0

}
