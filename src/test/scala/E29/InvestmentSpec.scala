package E29

import fi.kajstrom.efpscala.E29.Investment
import org.scalatest.{FlatSpec, Matchers}

class InvestmentSpec extends FlatSpec with Matchers{
  it should "return 18 with a rate of 4" in {
    Investment.yearsToDoubleWithRate(4) should be(18)
    Investment.yearsToDoubleWithRate(15) should be (5)
  }
}
