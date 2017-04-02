package fi.kajstrom.efpscala.E23.v2

import scala.io.StdIn._

/**
  * Alternative solution for E23 using the Composite design pattern
  */

class TroubleShooter extends {
  val terminationResult = new TerminationResult

  def start(): Unit = {
    isSilent.interact()
  }

  private def isSilent = {
    val isSilent = new Question(
      terminalsCorroded,
      clickingNoise,
      "Is the car silent when you turn the key?"
    )
    isSilent
  }

  private def clickingNoise = {
    val clickingNoise = new Question(
      new Result("Replate the battery."),
      crankUp,
      "Does the car make a clicking noise?"
    )
    clickingNoise
  }

  private def crankUp = {
    val crankUp = new Question(
      new Result("Check spark plug connections"),
      startAndDie,
      "Does the car crank up but fail to start?"
    )
    crankUp
  }

  private def startAndDie = {
    val startAndDie = new Question(
      fuelInjection,
      terminationResult,
      "Does the engine start and then die?"
    )
    startAndDie
  }

  private def fuelInjection = {
    val fuelInjection = new Question(
      new Result("Get it in for service"),
      new Result("Check to ensure the choke is opening and closing"),
      "Does your car have fuel injection?"
    )
    fuelInjection
  }

  private def terminalsCorroded = {
    val terminalsCorroded = new Question(
      new Result("Clean terminals and try starting again."),
      new Result("Replace cables and try again"),
      "Are the battery terminals corroded?"
    )
    terminalsCorroded
  }
}

abstract class Interaction{
  def interact(): Unit
  def isYes(str: String) : Boolean = str.toLowerCase == "y" || str.toLowerCase == "yes"
}

class Question(yes: Interaction, no: Interaction, question: String) extends Interaction{
  override def interact(): Unit = {
    if (isYes(readLine(question + " "))) {
      yes.interact()
    } else {
      no.interact()
    }
  }
}

class Result(outcome: String) extends Interaction{
  override def interact(): Unit = println(outcome)
}

class TerminationResult extends Interaction {
  override def interact(): Unit = {}//TerminationResult has no interaction}
}