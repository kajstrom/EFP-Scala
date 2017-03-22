package fi.kajstrom.efpscala.E11

import play.api.libs.json.JsResultException

import scala.io.StdIn._

object E11 extends App{
  val rateService = new ExchangeRateService()

  val toCurrency = promptCurrency
  val amount = promptAmount

  try {
    val rate = rateService.rateFor("USD", toCurrency)

    outputResult(rate, amount)
  } catch {
    case jre: JsResultException => println(s"Invalid currency: $toCurrency")
  }

  def promptCurrency: String = {
    readLine("What currency are you converting to? ").toUpperCase
  }
  def promptAmount: Int = {
    readLine("How much are you converting? ").toInt
  }
  def outputResult(rate: ExchangeRate, amount: Int): Unit = {
    val exchanged = rate.exchange(amount)

    println(f"$amount USD at a rate of ${rate.rate}%.2f is $exchanged%.2f ${rate.to}")
  }
}
