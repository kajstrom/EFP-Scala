package E17

import fi.kajstrom.efpscala.E17.BloodAlcohol
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Kaitsu on 27.3.2017.
  */
class BloodAlcoholSpec extends FlatSpec with Matchers{
  it should "return 0.26 with 14 ounces for a 180 pound male when it has been 2 hours since last drink" in {
    val ba = BloodAlcohol(14, 180, "m", 2)

    ba.bac() should equal(0.52)
  }

  it should "return take sex into consideration when calculating BAC" in {
    val ba = BloodAlcohol(14, 180, "f", 2)

    ba.bac() should equal(0.58)
  }

  it should "return false when BAC is over 0.08" in {
    val ba = BloodAlcohol(14, 180, "m", 2)

    ba.legalToDrive() should be (false)
  }

  it should "return true when BAC is under 0.08" in {
    val ba = BloodAlcohol(0, 180, "m", 0)

    ba.legalToDrive() should be (true)
  }
}