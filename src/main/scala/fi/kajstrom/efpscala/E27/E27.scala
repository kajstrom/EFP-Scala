package fi.kajstrom.efpscala.E27

import scala.io.StdIn._

object E27 extends App{

  validateInput(
    promptFirstName(),
    promptLastName(),
    promptZIP(),
    promptEmployeeId()
  )

  def promptFirstName() : String = readLine("Enter the first name: ")
  def promptLastName() : String = readLine("Enter the last name: ")
  def promptZIP() : String = readLine("Enter the ZIP code: ")
  def promptEmployeeId() : String = readLine("Enter an employee ID: ")

  def validateInput(firstName : String, lastName : String, zip : String, employeedId : String) : Unit = {
    var output = ""

    if (InputValidator.isNameNotFilledIn(firstName)) {
      output += "The first name must be filled in.\r\n"
    } else if (!InputValidator.isValidName(firstName)) {
      output = s"'$firstName' is not a valid first name. It is too short.\r\n"
    }

    if (InputValidator.isNameNotFilledIn(lastName)) {
      output += "The last name must be filled in.\r\n"
    } else if (!InputValidator.isValidName(lastName)) {
      output += s"'$lastName' is not a valid last name. It is too short.\r\n"
    }

    if (!InputValidator.isValidZIP(zip)) {
      output += "The ZIP code must be numeric.\r\n"
    }

    if (!InputValidator.isValidEmployeeId(employeedId)) {
      output += s"$employeedId is not a valid ID.\r\n"
    }

    if (output.length == 0) {
      output = "There were no errors found"
    }

    print(output)
  }
}
