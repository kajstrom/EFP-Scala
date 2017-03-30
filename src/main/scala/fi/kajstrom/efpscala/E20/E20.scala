package fi.kajstrom.efpscala.E20

import scala.io.StdIn._

/**
  * Created by Kaitsu on 30.3.2017.
  */
object E20 extends App{
  val state = promptState()

  val mstc = MultistateSalesTaxCalculator(
    state,
    promptCounty(state),
    promptOrderAmount()
  )

  output(mstc)

  def promptOrderAmount() : Int = readLine("What is the order amount? ").toInt
  def promptState() : String = readLine("What state do you live in? ")
  def promptCounty(state: String) : String = {
    if (state == "Wisconsin") {
      readLine("What is the county you live in? ")
    } else {
      ""
    }
  }

  def output(mstc: MultistateSalesTaxCalculator) : Unit = {
    var output = ""

    if (mstc.isTaxableState) {
      output += f"The tax is $$${mstc.tax}%.2f\r\n"
    }
    output += f"The total is  $$${mstc.total}%.2f"

    print(output)
  }
}
