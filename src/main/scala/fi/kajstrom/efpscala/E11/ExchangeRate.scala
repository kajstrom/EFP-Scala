package fi.kajstrom.efpscala.E11

/**
  * Created by Kaitsu on 18.3.2017.
  */
case class ExchangeRate(from: String, to: String, rate: Double) {
  def exchange(amount: Int): Double = amount * rate
}
