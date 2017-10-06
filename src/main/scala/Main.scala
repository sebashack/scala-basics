import book.{ Book }
import vehicle.{ CarModel, Year, Car, F1Car, Bike }
import shape.{ Shape }
import being._
import phantom._
import implicits.Reversed._
import implicits.ToJSON._
import person.{ Person, Address }

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
  def addCu2 = addCu3(10) _

  val something: Being[Int] = Something(12).map(x => x * 2)
  val orSomething: AnyVal = something.getOrElse(0.123123123)

  val nope: Int = Nothingness.getOrElse(12)

  val pkFire: Pokemon[Fire] = new Pokemon("Charmander", Attack("Fire Beam"))
  val pkElectric: Pokemon[Electric] = new Pokemon("Pikachu", Attack("Electric Blast"))

  val pkWater: Pokemon[Water] = new Pokemon("Squirtle", Attack("Water Bubbles"))
  val pkLeaf: Pokemon[Leaf] = new Pokemon("Bulbasaur", Attack("Leaf Whip"))

  val address = Address("Los Angeles", "West Coast")
  val person = Person("Sebastian", address)

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
  println(Shape.filterRecs(shapes))
  println(shapes.filter((s: Shape) => s.area > 30))
  println("-----------------")
  println("Uncurried")
  println(addUnc1(5))
  println("-----------------")
  println("Curried")
  println(addCu3(3)(4)(5))
  println("-----------------")
  val head :: tail = List(1,2,3)
  println(head)
  println(tail)
  println("-----------------")
  println(something)
  println(orSomething)
  println(nope)
  println("-----------------")
  println("Fire VS Electric")
  Battle.fireVsElectric(pkFire, pkElectric)
  println("-----------------")
  println("Water VS Leaf")
  Battle.waterVsLeaf(pkWater, pkLeaf)
  println("-----------------")
  println("Implicit Invocation: toRList")
  println("You know what I am talking about!".toRList())
  println("-----------------")
  println("Implicit Invocation: toJSON")
  println(person.toJSON)
}
