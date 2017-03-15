package E10

import fi.kajstrom.efpscala.E10.{Checkout, Item}
import org.scalatest.{FlatSpec, Matchers}

class CheckoutSpec extends FlatSpec with Matchers{
  val checkout = new Checkout(List[Item](
    new Item(25, 2),
    new Item(10, 1),
    new Item(4, 1)
  ))

  it should " return 64.00 as subtotal " in {
    checkout.subtotal() should equal(64.00)
  }

  it should " return 3.52 as tax " in {
    checkout.tax() should equal(3.52)
  }

  it should " return 67.52 as total" in {
    checkout.total() should equal(67.52)
  }
}
