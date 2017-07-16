package fi.kajstrom.efpscala.E57

import scala.io.StdIn.readLine

object E57 extends App{
  val game = new Game(Seq(Question("Wat?", Seq(Answer("Yes", false), Answer("No", false), Answer("68g", true)))))

  game.start()
  promptQuestion()

  def promptQuestion(): Unit = {
    val question = game.nextQuestion()

    println("Question: " + question.text)

    var nth = 0
    question.answers.foreach((answer: Answer) => {
      println(nth + ". " + answer.answer)
      nth += 1
    })

    val selectedAnswer = readLine("What is your answer? ")

    if (game.answer(selectedAnswer.toInt)) {
      println("Correct! Your current score is: " + game.getScore)
      promptQuestion()
    } else {
      gameOver()
    }
  }

  def gameOver(): Unit = {
    println("Game over! Your score is: " + game.getScore)
  }
}
