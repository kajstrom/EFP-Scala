package E32

import fi.kajstrom.efpscala.E32.{GuessTheNumber, TestDoubleGenerator}
import org.scalatest.{FlatSpec, Matchers}

class GuessTheNumberSpec extends FlatSpec with Matchers{


  it should "return -1 for a too low guess" in {
    val game = new GuessTheNumber(TestDoubleGenerator(5))

    game.guess(4) should be(-1)
  }

  it should "return 1 for a too high guess" in {
    val game = new GuessTheNumber(TestDoubleGenerator(5))

    game.guess(6) should be(1)
  }

  it should "return 0 for a correct guess" in {
    val game = new GuessTheNumber(TestDoubleGenerator(5))

    game.guess(5) should be(0)
  }

  it should "throw RuntimeException if attempting to guess in a completed gate" in {
    val game = new GuessTheNumber(TestDoubleGenerator(5))

    game.guess(5)
    an [RuntimeException] should be thrownBy game.guess(5)
  }
}
