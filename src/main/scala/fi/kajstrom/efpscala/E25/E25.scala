package fi.kajstrom.efpscala.E25

import scala.io.StdIn._

/**
  * @todo I'm not really satisfied with this numeric type code solution. Perhaps enumerations or case classes could be used.
  *
  * Exercise specification does not classify passwords containing only numbers or letters that are over 8 chars long.
  * Also unspecified is are passwords that contain letters and numbers but the length is less than 8 chars.
  */

object E25 extends App{
  val pv = new PasswordValidator

  val password = promptPassword()

  output(pv.validate(password), password)

  def promptPassword() : String = readLine("Enter password to be validated: ")

  def output(strengthType: Int, password: String) : Unit = {
    var passwordStrenthDescription = ""

    strengthType match {
        case 0 => passwordStrenthDescription = "password of unclassifed strenght"
        case 1 => passwordStrenthDescription = "very weak password"
        case 2 => passwordStrenthDescription = "weak password"
        case 3 => passwordStrenthDescription = "strong password"
        case 4 => passwordStrenthDescription = "very strong password"
    }

    println(s"The password '$password' is a $passwordStrenthDescription.")
  }
}
