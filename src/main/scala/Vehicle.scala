package vehicle

abstract class Vehicle(speed: Int) {
  def race() = println("Racing vehicle")
}


class Year(private val y: Int) extends AnyVal with Ordered[Year] {
  def compare(that: Year) = this.y - that.y
  def getYear: Int = y.abs
}

trait SportVehicle extends Vehicle {
  val extraSpeed: Int
  val sportTeam: String
}

case class CarModel(year: Year, brand: String)


class Car(val speed: Int) extends Vehicle(speed) {
  override def race() = println("Racing a car")
}

class F1Car(val speed: Int, val model: CarModel) extends Vehicle(speed) with SportVehicle {
  val extraSpeed: Int = 150
  val sportTeam: String = "Ferrari"

  def isModern(): Boolean  = this.model match {
    case CarModel(year, _) if year >= (new Year(2000)) => true
    case _ => false
  }

  override def race() = println("Racing a F1 car, max-speed: " + (extraSpeed + speed).toString())
}

class Bike(val speed: Int) extends Vehicle(speed) {
  override def race() = println("Racing Bike")
}
