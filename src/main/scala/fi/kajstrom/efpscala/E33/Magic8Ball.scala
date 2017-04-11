package fi.kajstrom.efpscala.E33

import scala.util.Random.nextInt

class Magic8Ball {
  val answers = Vector("Yes", "No", "Maybe", "Ask again later")

  def shake(): String = {
    answers(nextInt(answers.length))
  }
}
