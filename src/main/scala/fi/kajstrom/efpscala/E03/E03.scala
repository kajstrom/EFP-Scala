package fi.kajstrom.efpscala.E03

import scala.io.StdIn._

/**
  * Created by Kaitsu on 19.1.2017.
  */
object E03 {
  def main(args: Array[String]): Unit = {
    val quote = promptQuote()
    val from = promptFrom()

    val quoter = new Quoter

    outputResponse(quoter.quote(quote, from))
  }

  def promptQuote(): String = readLine("What is the quote? ")
  def promptFrom(): String = readLine("Who said it? ")
  def outputResponse(output: String): Unit = println(output)
}
