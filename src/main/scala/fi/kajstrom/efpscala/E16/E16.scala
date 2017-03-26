package fi.kajstrom.efpscala.E16

import scala.io.StdIn._

object E16 extends App{
  val dc = new DrivingAgeChecker()

  val age = promptAge()
  outputResult(dc, age)

  def promptAge(): Int = readLine("What is your age? ").toInt

  def outputResult(dc: DrivingAgeChecker, age: Int): Unit = {
    dc.oldEnoughToDrive(age) match {
        case true => println("You are old enough to legally drive")
        case false => println("You are not old enough to legally drive")
    }
  }
}
