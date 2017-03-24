package fi.kajstrom.efpscala.E13

import scala.math.pow

/**
  * Created by Kaitsu on 24.3.2017.
  */
case class CompoundInterest(principal: Int, rate: Double, years: Int, compoundPerYears: Int) {
  def investmentWorth(): Double = {
    val nt = compoundPerYears * years
    val rateAsDecimal = rate / 100
    val toExponent = 1 + (rateAsDecimal / compoundPerYears)

    val toBeRounded = pow(toExponent, nt) * principal

    BigDecimal(toBeRounded).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
  }
}
