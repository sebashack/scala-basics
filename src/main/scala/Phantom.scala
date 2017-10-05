package phantom


sealed trait Fire
sealed trait Electric
sealed trait Water
sealed trait Leaf

case class Pokemon[PkType](name: String, attack: Attack)

case class Attack(val name: String) {
  def doIt[T](pokemon: Pokemon[T]): Unit =
    println(s"Attack ${pokemon.name} with ${name}")
}

object Battle {
  def fireVsElectric(pk1: Pokemon[Fire], pk2: Pokemon[Electric]): Unit = {
    println(s"${pk1.name} do it!")
    pk1.attack.doIt(pk2)

    println(s"${pk2.name} do it!")
    pk2.attack.doIt(pk1)
  }

  def waterVsLeaf(pk1: Pokemon[Water], pk2: Pokemon[Leaf]): Unit = {
    println(s"${pk1.name} do it!")
    pk1.attack.doIt(pk2)

    println(s"${pk2.name} do it!")
    pk2.attack.doIt(pk1)
  }
}
