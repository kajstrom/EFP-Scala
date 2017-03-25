package E15

import fi.kajstrom.efpscala.E15.PasswordValidation
import org.scalatest.{FlatSpec, Matchers}

class PasswordValidationSpec extends FlatSpec with Matchers {
  it should "return true when user exists and password matches" in {
    val pv = new PasswordValidation()
    pv.addUser("root", "r00t")

    pv.isValid("root", "r00t") should equal(true)
  }

  it should "return false when user does not exists" in {
    val pv = new PasswordValidation()

    pv.isValid("root", "r00t") should equal(false)
  }

  it should "return false when user exists but password is wrong" in {
    val pv = new PasswordValidation()
    pv.addUser("root", "r00t")

    pv.isValid("root", "root") should equal(false)
  }

  it should "return false when password case does not match" in {
    val pv = new PasswordValidation()
    pv.addUser("root", "r00t")

    pv.isValid("root", "R00t") should equal(false)
  }
}