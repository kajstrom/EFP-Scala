package fi.kajstrom.efpscala.E32

import scala.util.Random.nextInt

class GuessTheNumber(answerGenerator: AnswerGenerator) {
  private val answer = answerGenerator.generate()
  private var guesses: List[Int] = List()
  private var gameRunning = true

  /**
    *
    * @param guess
    * @return 0 for correct answer. 1 for a guess that is too high, -1 for a guess that is too low
    */
  def guess(guess: Int): Int = {
    guardAgainstFinishedGames()
    addGuess(guess)
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

  private def guardAgainstFinishedGames(): Unit = {
    if (gameRunning == false) {
      throw new RuntimeException("Game is no longer running")
    }
  }

  def getScore: Int = guesses.length
  def isAlreadyGuessed(guess: Int): Boolean = guesses.contains(guess)

  def getScoreComment: String = {
    guardAgainstUnfinishedGames()

    if (getScore == 1) {
      "You're a mind reader!"
    } else if (getScore >= 2 && getScore <= 3) {
      "Most impressive."
    } else if (getScore >= 4 && getScore <= 6) {
      "You can do better than that."
    } else {
      "Better luck next time."
    }
  }

  private def guardAgainstUnfinishedGames() = {
    if (gameRunning) {
      throw new RuntimeException("Game is still running!")
    }
  }

  def addGuess(guess: Int): Unit = guesses :+= guess
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