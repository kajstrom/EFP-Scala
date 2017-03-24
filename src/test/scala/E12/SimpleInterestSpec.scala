package E12

import fi.kajstrom.efpscala.E12.SimpleInterest
import org.scalatest.{FlatSpec, Matchers}

class SimpleInterestSpec extends FlatSpec with Matchers{
  it should "return 1758 with rate of 4.3 in 4 years from principal amount of 1500" in {
    val interest = new SimpleInterest(1500, 4.3, 4)

    interest.investmentWorth() should equal(1758)
  }
}
