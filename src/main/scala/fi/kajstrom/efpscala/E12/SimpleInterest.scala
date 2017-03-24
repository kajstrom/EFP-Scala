package fi.kajstrom.efpscala.E12

case class SimpleInterest(principal: Int, rate: Double, years: Int) {
  def investmentWorth(): Int = (principal * (rate / 100) * years + principal).toInt
}
