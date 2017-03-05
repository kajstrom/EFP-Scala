package E09

import fi.kajstrom.efpscala.E09.PaintCalculator
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Kaitsu on 5.3.2017.
  */
class PaintCalculatorSpec extends FlatSpec with Matchers{
  it should "return 2 gallons with 20 x 18 feet ceiling" in {
    val paint = new PaintCalculator(20, 18)

    paint.gallons should equal(2)
  }
}
