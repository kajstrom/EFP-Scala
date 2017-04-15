package fi.kajstrom.efpscala.E37

import scala.io.StdIn._

object E37 extends App {
  val minLength = readLine("What's the minimum length? ").toInt
  val specialChars = readLine("How many special characters? ").toInt
  val numbers = readLine("How many numbers? ").toInt

  val pg = new PasswordGenerator()
  println("Your password is")
  println(pg.generate(minLength, specialChars, numbers))
}
