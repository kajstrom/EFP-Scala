package fi.kajstrom.efpscala.E21

import scala.io.StdIn._

object E21 extends App{

  output(NumberCalendar(promptMonthNumber()))

  def promptMonthNumber(): Int = readLine("Please enter the number of the month: ").toInt

  def output(nc: NumberCalendar) : Unit = {
    try {
      println(s"The name of the month is ${nc.monthName()}")
    } catch {
      case iae: IllegalArgumentException => println(iae.getMessage)
    }
  }
}
