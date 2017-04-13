package fi.kajstrom.efpscala.E36

import scala.math.BigDecimal.RoundingMode

/**
  * Created by Kaitsu on 13.4.2017.
  */
class StatisticsCalculator {
  def calculate(numbers: Vector[Int]) : Statistics = {
    var minimum = 0
    var maximum = 0
    var average = 0.0
    var stdDeviation = 0.0


    //Exercise constraint is to use loops. I'd prefer collection methods otherwise.
    numbers.foreach((number: Int) => {
      if (number < minimum) {
        minimum = number
      } else if (minimum == 0) {
        minimum = number
      }

      if (number > maximum) {
        maximum = number
      }

      average += number
    })

    average = average.toDouble / numbers.length

    //Std deviation
    numbers.foreach((number: Int) => {
      var diffFromMean = number - average
      diffFromMean = scala.math.abs(diffFromMean)
      diffFromMean = diffFromMean * diffFromMean

      stdDeviation += diffFromMean
    })

    stdDeviation = stdDeviation / numbers.length
    stdDeviation = scala.math.sqrt(stdDeviation)
    stdDeviation = BigDecimal(stdDeviation).setScale(2, RoundingMode.HALF_UP).toDouble

    Statistics(
      average,
      minimum,
      maximum,
      stdDeviation
    )
  }
}

case class Statistics(average: Double, minimum: Int, maximum: Int, standardDeviation: Double) {}