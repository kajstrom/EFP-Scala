package fi.kajstrom.efpscala.E12

import scala.io.StdIn._

object E12 extends App {
    val investment = new SimpleInterest(
      promptPrincipal(),
      promptRate(),
      promptYears()
    )

    outputResult(investment)

    def promptPrincipal() : Int = readLine("Enter the principal: ").toInt
    def promptRate() : Double = readLine("Enter the rate of interest: ").toDouble
    def promptYears() : Int = readLine("Enter the number of years: ").toInt

    def outputResult(investment: SimpleInterest) : Unit = {
      println(s"After ${investment.years} years at ${investment.rate}%, the investment will be worth ${investment.investmentWorth()}.")
    }
}
