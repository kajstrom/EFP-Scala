package fi.kajstrom.efpscala.E28

import scala.io.StdIn._

object E28 extends App{

  var numbers: List[Int] = List[Int]()

  val numbersToPrompt = promptNumbersToPrompt()
  var index = 0
  for (index <- 1 to numbersToPrompt) {
    numbers = numbers :+ promptNumber()
  }

  println("The total is " + numbers.sum.toString)

  def promptNumbersToPrompt() : Int = readLine("How many numbers do you want to add? ").toInt
  def promptNumber() : Int = readLine("Enter a number: ").toInt
}
