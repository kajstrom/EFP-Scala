package fi.kajstrom.efpscala.E02

import scala.io.StdIn._

/**
  * Created by Kaitsu on 15.1.2017.
  */
object E02 {
  def main(args: Array[String]): Unit = {
    val charCounter = new CharCounter

    val string = promptString()

    outputResponse(charCounter.reportStrLen(string))
  }

  def promptString(): String = readLine("What is the input string?")
  def outputResponse(response: String): Unit = println(response)
}
