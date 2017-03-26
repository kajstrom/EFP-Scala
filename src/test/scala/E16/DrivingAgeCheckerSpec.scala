package E16

import fi.kajstrom.efpscala.E16.DrivingAgeChecker
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Kaitsu on 26.3.2017.
  */
class DrivingAgeCheckerSpec extends FlatSpec with Matchers{
  val dc = new DrivingAgeChecker()

  it should "return false when driver is under 16" in {
    dc.oldEnoughToDrive(15) should equal(false)
  }

  it should "return true when driver is 16 or older" in {
    dc.oldEnoughToDrive(16) should equal(true)
    dc.oldEnoughToDrive(20) should equal(true)
  }
}
