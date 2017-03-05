package fi.kajstrom.efpscala.E06
import java.time.LocalDate

import scala.io.StdIn._

/**
  * Created by Kaitsu on 5.2.2017.
  */
object E06 extends App{
  val currentYear = LocalDate.now().getYear()

  val rc = new RetirementCalculator(currentYear)

  val currentAge = promptCurrentAge()
  val retirementAge = promptRetirementAge()

  outputResult(
    rc.yearsToRetirement(currentAge, retirementAge),
    rc.yearToRetire(currentAge, retirementAge),
    currentYear
  )

  def promptCurrentAge(): Int = readLine("What is your current age? ").toInt
  def promptRetirementAge(): Int = readLine("At what age would you like to retire? ").toInt
  def outputResult(yearsToRetirement: Int, retirementYear: Int, currentYear: Int): Unit = {
    println(s"You have ${yearsToRetirement} years left until you can retire.")
    println(s"It's $currentYear, so you can retire in $retirementYear")
  }
}
