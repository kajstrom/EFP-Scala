package fi.kajstrom.efpscala.E29

import scala.io.StdIn._

object E29 extends App{
  val rate = promptRate()

  def promptRate(): Int = {
    var breakOut = false
    var rate = 0

    //Exercise requires to use a loop. I would have opted for recursion.
    while (!breakOut) {
      try {
        rate = readLine("What is the rate of return?").toInt
        breakOut = true
      } catch {
        case nfe: NumberFormatException => {
          println("Sorry. That's not a valid input.")
        }
      }
    }

    rate
  }
}

object Investment {
  def yearsToDoubleWithRate(rate: Int) = math.ceil(72 / rate.toDouble).toInt
}