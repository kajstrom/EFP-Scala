package E13

import fi.kajstrom.efpscala.E13.CompoundInterest
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Kaitsu on 24.3.2017.
  */
class CompoundInterestSpec extends FlatSpec with Matchers{
  it should "return 1938.84 with principal of 1500 over 6 years at rate of 4.3 compounded 6 times per year" in {
    val investment = new CompoundInterest(1500, 4.3, 6, 4)

    investment.investmentWorth() should equal(1938.84)
  }
}
