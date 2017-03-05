package E06

import fi.kajstrom.efpscala.E06.RetirementCalculator
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Kaitsu on 5.2.2017.
  */
class RetirementCalculatorSpec extends FlatSpec with Matchers{
  "yearToRetire" should "return 2051 when age is 33 and retirement age 67 and the current year is 2017" in {
    val rc = new RetirementCalculator(2017)

    rc.yearToRetire(33, 67) should be (2051)
  }

  "yearsToRetirement" should "return 34 when age is 33 and retirement age 67 when current year is 2017" in {
    val rc = new RetirementCalculator(2017)

    rc.yearsToRetirement(33, 67) should be (34)
  }
}
