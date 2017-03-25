package fi.kajstrom.efpscala.E14

/**
  * Created by Kaitsu on 25.3.2017.
  */
case class TaxCalculator(amount: Int, state: String) {
  val wisconsinTax = 5.5

  def subtotal(): Double = amount.toDouble
  def tax(): Double = {
    var tax = 0.00
    if (state.toUpperCase() == "WI") {
      tax = amount * (wisconsinTax / 100)
    }

    tax
  }
  def total(): Double = tax() + subtotal()
}
