package fi.kajstrom.efpscala.E36Actor

import akka.actor.Actor

import scala.math.BigDecimal.RoundingMode

class StandardDeviationCalculator extends Actor{
  def receive = {
    case calculate: Calculate => {
      context.parent ! StandardDeviationCalculated(calculate.requestId, standardDeviationOf(calculate.numbers))
    }
  }

  def standardDeviationOf(numbers: Vector[Int]): Double = {
    var stdDeviation = 0.0
    val average = numbers.sum / numbers.length

    //Std deviation
    numbers.foreach((number: Int) => {
      var diffFromMean = number - average
      diffFromMean = scala.math.abs(diffFromMean)
      diffFromMean = diffFromMean * diffFromMean

      stdDeviation += diffFromMean
    })

    stdDeviation = stdDeviation / numbers.length
    stdDeviation = scala.math.sqrt(stdDeviation)

    BigDecimal(stdDeviation).setScale(2, RoundingMode.HALF_UP).toDouble
  }
}

case class StandardDeviationCalculated(reguestId: Int, standardDeviation: Double)
