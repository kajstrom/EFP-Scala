package fi.kajstrom.efpscala.E20

case class MultistateSalesTaxCalculator(state: String, county: String, orderAmount: Int) {
  val wisconsinTax = 0.05
  val illinoisTax = 0.08
  val eauClaireTaxAddition = 0.005
  val dunnTaxAddition = 0.004

  def isTaxableState = state == "Wisconsin" || state == "Illinois"

  def tax(): Double = {
    var tax = 0.00

    if (state == "Wisconsin") {
      if (county == "Eau Claire") {
        tax = orderAmount * (wisconsinTax + eauClaireTaxAddition)
      } else if (county == "Dunn") {
        tax = orderAmount * (wisconsinTax + dunnTaxAddition)
      } else {
        tax = orderAmount * wisconsinTax
      }
    } else if (state == "Illinois") {
      tax = orderAmount * illinoisTax
    }

    BigDecimal(tax).setScale(3, BigDecimal.RoundingMode.UP).toDouble
  }
  def total(): Double = BigDecimal(tax + orderAmount.toDouble).setScale(2, BigDecimal.RoundingMode.UP).toDouble
}
