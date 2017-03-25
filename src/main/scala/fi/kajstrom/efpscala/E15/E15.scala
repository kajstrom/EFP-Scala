package fi.kajstrom.efpscala.E15

import scala.io.StdIn._

object E15 extends App{

  val pv = new PasswordValidation()
  pv.addUser("user", "12345")


  output(
    pv,
    promptUsername(),
    promptPassword()
  )

  def promptUsername(): String = readLine("What is username? ")
  def promptPassword() : String = readLine("What is the password? ")

  def output(pv: PasswordValidation, username: String, password: String) : Unit = {
    if (pv.isValid(username, password)) {
      println("Welcome!")
    } else {
      println("I don't know you!")
    }
  }
}
