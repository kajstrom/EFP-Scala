package E22

import fi.kajstrom.efpscala.E22.LargestNumber
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Kaitsu on 1.4.2017.
  */
class LargestNumberSpec extends FlatSpec with Matchers {

  it should "return false if all numbers are not equal" in {
    LargestNumber(1, 2, 3).areAllEqual should be (false)
  }

  it should "return true if all numbers are equal" in {
    LargestNumber(2, 2, 2).areAllEqual should be(true)
  }

  it should "return 3 if with numbers 1, 2, 3" in {
    LargestNumber(1, 2, 3).largest should be(3)
    LargestNumber(3, 2, 1).largest should be(3)
    LargestNumber(2, 3, 1).largest should be(3)
  }
}
