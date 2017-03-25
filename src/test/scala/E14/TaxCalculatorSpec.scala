package E14

import fi.kajstrom.efpscala.E14.TaxCalculator
import org.scalatest.{FlatSpec, Matchers}

class TaxCalculatorSpec extends FlatSpec with Matchers{
  it should "return 10.00 for subtotal when amount is 10" in {
    val tc = TaxCalculator(10, "WI")

    tc.subtotal() should equal(10.00)
  }

  it should "return 0.55 for tax when amount is 10 and state is WI" in {
    val tc = TaxCalculator(10, "WI")

    tc.tax() should equal(0.55)
  }

  it should "return 10.55 for total when amount is 10 and state is WI" in {
    val tc = TaxCalculator(10, "WI")

    tc.total() should equal(10.55)
  }

  it should "return 0 for tax when state is not WI and amount is 20" in {
    val tc = TaxCalculator(20, "CO")

    tc.tax() should equal(0)
  }

  it should "return 20 for total when state is not WI and amount is 20" in {
    val tc = TaxCalculator(20, "CO")

    tc.total() should equal(20)
  }
}
