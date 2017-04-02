package fi.kajstrom.efpscala.E23

/**
  * Simplistic implementation. Turning each question into an object would be a cleaner solution.
  *
  * @param cla
  */
class CarTroubleShooter(cla: CommandLineAdapter) {
  def start(): Unit = {
    isCarSilentWhenYouTurnTheKey()
  }

  def isYes(string: String): Boolean = string.toLowerCase == "y" || string.toLowerCase == "yes"

  def isCarSilentWhenYouTurnTheKey(): Unit = {
    val resp = cla.readLine("Is the car silent when you turn the key?")

    if (isYes(resp)) {
      areBattCordsCorroded()
    } else {
      doesCarMakeClickingNoise()
    }
  }

  def areBattCordsCorroded() : Unit = {
    val resp = cla.readLine("Are battery cords corroded?")

    if (isYes(resp)) {
      cla.output("Clean terminals and try again")
    } else {
      cla.output("Replaces cables and try again")
    }
  }

  def doesCarMakeClickingNoise() : Unit = {
    val resp = cla.readLine("Does the car make a clicking noise?")

    if (isYes(resp)) {
      cla.output("Replace the battery")
    } else {
      doesTheCarCrankUp()
    }
  }

  def doesTheCarCrankUp() : Unit = {
    val resp = cla.readLine("Does the car crank up but fail to start")

    if (isYes(resp)) {
      cla.output("Check spark plug connections")
    } else {
      doesTheEngineStart()
    }
  }

  def doesTheEngineStart() : Unit = {
    val resp = cla.readLine("Does the engine start and then die? ")

    if (isYes(resp)) {
      doesCarHaveFuelInjection()
    }
  }

  def doesCarHaveFuelInjection() : Unit = {
    val resp = cla.readLine("Does your car have fuel injection? ")

    if (isYes(resp)) {
      cla.output("Get it in for service")
    } else {
      cla.output("Check to ensure the choke is opening and closing")
    }
  }
}


class CommandLineAdapter {
  def output(output: String): Unit = println(output)
  def readLine(output: String): String = scala.io.StdIn.readLine(output)
}