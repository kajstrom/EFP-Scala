package fi.kajstrom.efpscala.E32

import scala.io.StdIn._

object E32 extends App{

  play()

  def promptDifficulty(): Int = {
    try {
      readLine("Pick a difficulty level(1, 2 or 3): ").toInt
    } catch {
      case nfe: NumberFormatException => {
        println("Invalid number...")
        promptDifficulty()
      }
    }
  }

  def promptGuess(game: GuessTheNumber): Int = {
    try {
      if (game.getScore == 0) {
        readLine("I have my number. What's your guess?  ").toInt
      } else {
        readLine("Guess again: ").toInt
      }
    }
    catch {
      case nfe: NumberFormatException => {
        println("Invalid number...")
        game.incrementTimesGuessed()
        promptGuess(game)
      }
    }
  }

  def promptToPlayAgain() : Unit = {
    if (readLine("Play again? ").toLowerCase == "y") {
      play()
    } else {
      println("Goodbye!")
    }
  }

  def play(): Unit = {
    println("Let's play Guess the Number.")
    val difficultyLevel = promptDifficulty()

    val game = new GuessTheNumber(RandomAnswerGenerator(difficultyLevel))

    while(game.isRunning) {
      val result = game.guess(promptGuess(game))

      if (result == 1) {
        print("Too high. ")
      } else if (result == -1) {
        print("Too low. ")
      }
    }

    println(s"You got it in ${game.getScore} guesses! ${game.getScoreComment}")
    promptToPlayAgain()
  }
}
