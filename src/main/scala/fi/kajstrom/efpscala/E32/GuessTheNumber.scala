package fi.kajstrom.efpscala.E32

import scala.util.Random.nextInt

class GuessTheNumber(answerGenerator: AnswerGenerator) {
  private val answer = answerGenerator.generate()
  private var guesses = 0
  private var gameRunning = true

  /**
    *
    * @param guess
    * @return 0 for correct answer. 1 for a guess that is too high, -1 for a guess that is too low
    */
  def guess(guess: Int): Int = {
    guardAgainstFinishedGames
    incrementTimesGuessed()
    evaluateGuess(guess)
  }

  private def evaluateGuess(guess: Int) = {
    if (answer == guess) {
      gameRunning = false
      0
    } else if (answer < guess) {
      1
    } else {
      -1
    }
  }

  private def guardAgainstFinishedGames = {
    if (gameRunning == false) {
      throw new RuntimeException("Game is no longer running")
    }
  }

  def getScore: Int = guesses

  def getScoreComment: String = {
    guardAgainstUnfinishedGames

    if (guesses == 1) {
      "You're a mind reader!"
    } else if (guesses >= 2 && guesses <= 3) {
      "Most impressive."
    } else if (guesses >= 4 && guesses <= 6) {
      "You can do better than that."
    } else {
      "Better luck next time."
    }
  }

  private def guardAgainstUnfinishedGames = {
    if (gameRunning) {
      throw new RuntimeException("Game is still running!")
    }
  }

  def incrementTimesGuessed(): Unit = guesses += 1
  def isRunning: Boolean = gameRunning
}

trait AnswerGenerator {
  def generate(): Int = ???
}

case class RandomAnswerGenerator(difficulty: Int) extends AnswerGenerator{
  override def generate(): Int = {
    if (difficulty == 1) {
      1 + nextInt(10)
    } else if (difficulty == 2) {
      1 + nextInt(100)
    } else {
      1 + nextInt(1000)
    }
  }
}

case class TestDoubleGenerator(answer: Int) extends AnswerGenerator {
  override def generate(): Int = answer
}