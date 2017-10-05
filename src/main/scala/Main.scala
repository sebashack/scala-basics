import book.{ Book }
import vehicle.{ CarModel, Year, Car, F1Car, Bike }
import shape.{ Shape }
import being._

object Main extends App {
  val book = new Book("Scala Basics", 139182739)

  val circle = Shape(23)
  val rectangle = Shape(4, 5)

  val car = new Car(250)
  val f1Model = CarModel(new Year(2020), "Ferrari Galaxy")
  val f1Car = new F1Car(300, f1Model)
  val bike = new Bike(70)

  val shapes = List (Shape(5), Shape(5, 5), Shape(7), Shape(8, 9))

  val addUnc3: (Int, Int, Int) => Int = (x: Int, y: Int, z: Int) => x + y + z
  val addUnc2: (Int, Int) => Int = addUnc3(3, _:Int, _:Int)
  val addUnc1: Int => Int = addUnc2(4, _:Int)

  def addCu3(x: Int)(y: Int)(z: Int): Int = x + y + z
  def addCu3_(x: Int) = (y: Int) => (z: Int) => x + y + z

  val something: Being[Int] = Something(12).map(x => x * 2)
  val nope: Int = Nothingness.getOrElse(12)

  println("-----------------")
  book.printInfo
  println("-----------------")
  circle.printInfo
  println("-----------------")
  rectangle.printInfo
  println("-----------------")
  car.race()
  f1Car.race()
  bike.race()
  println("-----------------")
  println(Shape.filterRecs(shapes).toString())
  println(shapes.filter((s: Shape) => s.area > 30))
  println("-----------------")
  println("Uncurried")
  println(addUnc1(5).toString())
  println("-----------------")
  println("Curried")
  println(addCu3(3)(4)(5).toString())
  println("-----------------")
  val head :: tail = List(1,2,3)
  println(head.toString())
  println(tail.toString())
  println("-----------------")
  println(something.toString)
  println(nope.toString())
  println("-----------------")
}
