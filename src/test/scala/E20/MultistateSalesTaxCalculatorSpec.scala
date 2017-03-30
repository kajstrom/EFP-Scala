package E20

import fi.kajstrom.efpscala.E20.MultistateSalesTaxCalculator
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Kaitsu on 30.3.2017.
  */
class MultistateSalesTaxCalculatorSpec extends FlatSpec with Matchers{
  it should "return 0.50 tax and 10.50 total for an order amount of 10 in Wisconsin " in {
    val multistateSalesTaxCalculator = MultistateSalesTaxCalculator("Wisconsin", "Some county", 10)

    multistateSalesTaxCalculator.total should equal(10.50)
    multistateSalesTaxCalculator.tax should equal(0.50)
  }

  it should "return 0.55 tax and 10.55 total for an order amount of 10.55 in Wisconsin county Eau Claire" in {
    val multistateSalesTaxCalculator = MultistateSalesTaxCalculator("Wisconsin", "Eau Claire", 10)

    multistateSalesTaxCalculator.total should equal(10.55)
    multistateSalesTaxCalculator.tax  should equal(0.55)
  }

  it should "return 0.54 tax and 10.54 total for an order amount of 10 in Wisconsin county Dunn" in {
    val multistateSalesTaxCalculator = MultistateSalesTaxCalculator("Wisconsin", "Dunn", 10)

    multistateSalesTaxCalculator.total should equal(10.54)
    multistateSalesTaxCalculator.tax should equal(0.54)
  }

  it should "return 0.80 tax and 10.80 total for an order amount of 10 in Illinois" in {
    val multistateSalesTaxCalculator = MultistateSalesTaxCalculator("Illinois", "", 10)

    multistateSalesTaxCalculator.total should equal(10.80)
    multistateSalesTaxCalculator.tax should equal(0.80)
  }

  it should "return 0.00 tax and 10.00 total for an order amount in any other state" in {
    val multistateSalesTaxCalculator = MultistateSalesTaxCalculator("New York", "", 10)

    multistateSalesTaxCalculator.total should equal(10.00)
    multistateSalesTaxCalculator.tax should equal(0.00)
  }
}
