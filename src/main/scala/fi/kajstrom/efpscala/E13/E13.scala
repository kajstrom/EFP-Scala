package fi.kajstrom.efpscala.E13

import scala.io.StdIn._

object E13 extends App{

  val interest = new CompoundInterest(
    promptPrincipal(),
    promptRate(),
    promptYears(),
    promptCompoundedPerYear()
  )

  outputResult(interest)

  def promptPrincipal() :  Int = readLine("What is the principal amount? ").toInt
  def promptRate() : Double = readLine("What is the rate? ").toDouble
  def promptYears() : Int = readLine("What is the number of years? ").toInt
  def promptCompoundedPerYear() : Int = readLine("What is the number of times the interest is compounded per year? ").toInt

  def outputResult(interest: CompoundInterest) : Unit = {
    println(s"$$${interest.principal} invested at ${interest.rate}% for ${interest.years} years compounded ${interest.compoundPerYears} times per year is $$${interest.investmentWorth()}")
  }
}
