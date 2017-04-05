package E27

import fi.kajstrom.efpscala.E27.InputValidator
import org.scalatest.{FlatSpec, Matchers}

class InputValidatorSpec extends FlatSpec with Matchers{
  it should "return false for name shorter than 2 chars" in {
    InputValidator.isValidName("K") should be(false)
  }

  it should "return true for name 2 chars or longer" in {
    InputValidator.isValidName("Kaj") should be (true)
  }

  it should "return true for empty name" in {
    InputValidator.isNameNotFilledIn("") should be (true)
  }

  it should "return false for non-empty name" in {
    InputValidator.isNameNotFilledIn("Kaj") should be (false)
  }

  it should "return false for ZIP code that is not fully numeric" in {
    InputValidator.isValidZIP("65A00") should be (false)
  }

  it should "return true for ZIP code that is fully numeric" in {
    InputValidator.isValidZIP("65100") should be (true)
  }

  it should "return false for employee id A12-1234" in {
    InputValidator.isValidEmployeeId("A12-1234") should be (false)
  }

  it should "return true for employee id TK-4321" in {
    InputValidator.isValidEmployeeId("TK-4321") should be(true)
  }
}
