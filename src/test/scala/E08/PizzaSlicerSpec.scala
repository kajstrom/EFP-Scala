package E08

import fi.kajstrom.efpscala.E08.PizzaSlicer
import org.scalatest.{FlatSpec, Matchers}

class PizzaSlicerSpec extends FlatSpec with Matchers{
  it should "with 8 people and 2 pizzas with 8 slices each" in{
    val slicer = new PizzaSlicer(8, 2, 8)

    slicer.slicesPerPerson should equal(2)
    slicer.leftovers() should equal(0)
  }

  it should "with 8 people and 3 pizzas with 3 slices each" in {
    val slicer = new PizzaSlicer(8, 3, 3)

    slicer.slicesPerPerson should equal(1)
    slicer.leftovers() should equal(1)
  }
}
