package E02

import fi.kajstrom.efpscala.E02.CharCounter
import org.scalatest._

/**
  * Created by Kaitsu on 15.1.2017.
  */
class CharCounterSpec extends FlatSpec with Matchers{
  "reportStrLen" should "return properly formatted result" in {
    val charCounter = new CharCounter()
    charCounter.reportStrLen("Kaj") should be ("Kaj has 3 characters.")
  }
}
