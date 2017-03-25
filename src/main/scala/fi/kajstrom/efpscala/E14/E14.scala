package fi.kajstrom.efpscala.E14

import scala.io.StdIn._

object E14 extends App{

  val tc = TaxCalculator(
    promptOrderAmount(),
    promptState()
  )

  output(tc)

  def promptOrderAmount(): Int = readLine("What is the order amount? ").toInt
  def promptState(): String = readLine("What is the state? ").toUpperCase

  def output(tc: TaxCalculator) : Unit = {
    if (tc.state == "WI") {
      println(s"The subtotal is $$${tc.subtotal()}")
      println(f"The tax is $$${tc.tax()}%.2f")
    }
    println(f"The total is $$${tc.total()}%.2f")
  }
}
