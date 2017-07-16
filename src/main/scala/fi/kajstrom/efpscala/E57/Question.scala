package fi.kajstrom.efpscala.E57

import play.api.libs.functional.syntax._
import play.api.libs.json.{JsPath, Reads}

object Question {
  implicit val questionReads: Reads[Question] = (
      (JsPath \ "question").read[String] and
      (JsPath \ "answers").read[Seq[Answer]]
    )(Question.apply _)
}

case class Question(text: String, answers: Seq[Answer]) {
  def isCorrect(nth: Int): Boolean = {
    answers(nth).correct
  }
}

object Answer {
  implicit val answerReads: Reads[Answer] = (
    (JsPath \ "answer").read[String] and
    (JsPath \ "correct").read[Boolean]
  )(Answer.apply _)
}

case class Answer(answer: String, correct: Boolean)