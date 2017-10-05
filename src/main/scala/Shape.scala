package shape

import scala.math.{ Pi }

trait Shape {
  def area: Double
  def printInfo: Unit = {
    println("Shape: " + this.toString())
    println("Area: " + area.toString())
  }
}

object Shape {
  private case class Circle(radius: Double) extends Shape {
    val area = Pi.*(radius).*(radius) // Arith operations without sugar syntax
  }

  private case class Rectangle(height: Double, width: Double) extends Shape {
    val area = height * width
  }

  def filterRecs(shapes: List[Shape]): List[Shape] = shapes match {
    case Rectangle(_, _) :: ss => filterRecs(ss)
    case (c@Circle(_)) :: ss => c :: filterRecs(ss)
    case _ :: ss => filterRecs(ss)
    case Nil => Nil
  }

  def apply(height: Double, width: Double): Shape = new Rectangle(height, width)
  def apply(radius: Double): Shape = new Circle(radius)
}
