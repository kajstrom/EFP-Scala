package E25

import fi.kajstrom.efpscala.E25.PasswordValidator
import org.scalatest.{FlatSpec, Matchers}

class PasswordValidatorSpec extends FlatSpec with Matchers{
  val pv = new PasswordValidator()

  it should "return 1 for 12345" in {
    pv.validate("12345") should be(1)
  }

  it should "return 2 for abcdef" in {
    pv.validate("abcdef") should be(2)
  }

  it should "return 3 for abc123xyz" in {
    pv.validate("abc123xyz") should be(3)
  }

  it should "return 4 for 1337h@xor" in {
    pv.validate("1337h@xor") should be(4)
  }
}
