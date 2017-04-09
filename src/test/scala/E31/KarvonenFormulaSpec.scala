package E31

import fi.kajstrom.efpscala.E31.KarvonenFormula
import org.scalatest.{FlatSpec, Matchers}

class KarvonenFormulaSpec extends FlatSpec with Matchers{
  it should "return correct values for intensity" in {
    val kf = KarvonenFormula(22, 65)

    kf.forIntensity(55) should be(138)
    kf.forIntensity(60) should be(145)
    kf.forIntensity(95) should be(191)
  }
}
