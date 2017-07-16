package fi.kajstrom.efpscala.E57

case class Question(text: String, answers: Seq[Answer]) {
  def isCorrect(nth: Int): Boolean = {
    answers(nth).correct
  }
}

case class Answer(answer: String, correct: Boolean)