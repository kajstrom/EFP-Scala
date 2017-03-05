package E04

import fi.kajstrom.efpscala.E04.MadLib
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Kaitsu on 22.1.2017.
  */
class MadLibSpec extends FlatSpec with Matchers{
  "sentence" should "return correctly formatted sentece" in {
    val madLib = new MadLib

    madLib.sentence("dog", "walk", "blue", "quickly") should be ("Do you walk your blue dog quickly? That's hilarious!")
  }
}
