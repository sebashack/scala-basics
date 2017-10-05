package being

// Classes
sealed abstract class Being[+A] {
  def get: A
  def isEmpty: Boolean

  final def getOrElse[B >: A](default: => B): B =
    if (this.isEmpty) default else this.get

  final def map[B](f: A => B): Being[B] =
    if (this.isEmpty) Nothingness else Something(f(this.get))
}

final case class Something[+A](value: A) extends Being[A] {
  def get = value
  def isEmpty = false
}

case object Nothingness extends Being[Nothing] {
  def get = throw new NoSuchElementException("None.get")
  def isEmpty = true
}


// Companion object: Factory
object Being {
  def apply[B](x: B): Being[B] = Something(x)
  def apply[B](): Being[B] = Nothingness
}
