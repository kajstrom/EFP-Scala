package fi.kajstrom.efpscala.E37

import scala.util.Random

class PasswordGenerator {
  val chars = List(
    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
    "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")
  val specialChars = List("$", "!", "#", "*", "¤", "%", "^", "+", "?", "'", "`")

  def generate(minLength: Int, specialCharsCount: Int, numbers: Int): String = {
    val charCount = (minLength - specialCharsCount) - numbers
    var password = ""

    for (i <- 0 until charCount) {
      password += chars(Random.nextInt(chars.length))
    }

    for (i <- 0 until specialCharsCount) {
      password += specialChars(Random.nextInt(specialChars.length))
    }

    for (i <- 0 until numbers) {
      password += Random.nextInt(9).toString
    }

    Random.shuffle(password.toList).mkString
  }
}
