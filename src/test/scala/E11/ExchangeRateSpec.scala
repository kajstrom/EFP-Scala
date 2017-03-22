package E11

import fi.kajstrom.efpscala.E11.ExchangeRate
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Kaitsu on 22.3.2017.
  */
class ExchangeRateSpec extends FlatSpec with Matchers {
  it should " return 20 when amount is 10 and rate is 2" in {
      val rate = new ExchangeRate("USD", "EUR", 2.00)

      rate.exchange(10) should equal(20)
  }
}
