package fi.kajstrom.efpscala.E38

import scala.io.StdIn._

object E38 extends App{
  val numberString = readLine("Enter a list of numbers, separated by spaces: ")
  val numbers = numberString.split(" ").toList.map(_.toInt)
  val evenNumbers = filterEvenNumbers(numbers)

  print("The even numbers are ")
  print(evenNumbers.mkString(" "))

  def filterEvenNumbers(numbers: List[Int]): List[Int] = {
    var evenNumbers = List[Int]()
      for (number <- numbers) {
        if (number % 2 == 0) {
          evenNumbers :+= number
        }
      }

    evenNumbers
  }
}
