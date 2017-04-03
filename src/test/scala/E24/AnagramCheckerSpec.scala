package E24

import fi.kajstrom.efpscala.E24.AnagramChecker
import org.scalatest.{FlatSpec, Matchers}

class AnagramCheckerSpec extends FlatSpec with Matchers{
  val ac = new AnagramChecker()

  it should "return true for anagrams" in {
    ac.isAnagram("tone", "note") should be (true)
    ac.isAnagram("silent", "listen") should be (true)
    ac.isAnagram("admirer", "married") should be (true)
  }

  it should "return false for words that are not anagrams" in {
    ac.isAnagram("pork", "chicken") should be (false)
  }
}
