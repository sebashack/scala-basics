package implicits
import person.{ Person, Address }

object Reversed {
  implicit final class StrList(val str: String) {
    def toRList(): List[Char] = {
      var l: List[Char] = Nil
      for (c <- str)
        l = c :: l
      l
    }
  }
}

trait ToJSON {
  def toJSON: String
}

object ToJSON {
  implicit class AddressToJSON(address: Address) extends ToJSON {
    def toJSON: String = s"{ street: ${address.street}, city: ${address.city} }"
  }

  implicit class PersonToJSON(person: Person) extends ToJSON {
    def toJSON: String = s"{ name: ${person.name}, address: ${person.address.toJSON} }"
  }
}
