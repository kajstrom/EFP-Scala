package fi.kajstrom.efpscala.E08

/**
  * Created by Kaitsu on 5.3.2017.
  */
case class PizzaSlicer(people: Int, pizzas: Int, slicesPerPizza: Int) {
  val totalSlices = pizzas * slicesPerPizza

  def slicesPerPerson(): Int = totalSlices / people
  def leftovers(): Int = totalSlices - slicesPerPerson() * people
}
