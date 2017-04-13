package fi.kajstrom.efpscala.E36

import scala.io.StdIn._

object E36 extends App{
  var numbers = Vector[Int]()
  var running = true

  while (running) {
    val input = readLine("Enter a number: ")

    if (input != "done") {
      try {
        numbers = numbers :+ input.toInt
      } catch {
        case nfe: NumberFormatException => println("That's not a valid number...")
        case _ => println("What seems to be the officer, problem?")
      }
    } else {
      running = false
    }
  }

  val sc = new StatisticsCalculator
  val statistics = sc.calculate(numbers)

  println(s"The average is ${statistics.average}.")
  println(s"The minimum is ${statistics.minimum}.")
  println(s"The maximum is ${statistics.maximum}.")
  println(s"The population standard deviation is ${statistics.standardDeviation}.")
}
