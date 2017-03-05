package E03

import fi.kajstrom.efpscala.E03.Quoter
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Kaitsu on 19.1.2017.
  */
class QuoterSpec extends FlatSpec with Matchers {
  "quote" should "return properly quoted string" in {
    val quoter = new Quoter()

    quoter.quote("These aren't the droids you are looking for.", "Obi-Wan Kenobi") should be ("Obi-Wan Kenobi says, \"These aren't the droids you are looking for.\"")
  }
}
