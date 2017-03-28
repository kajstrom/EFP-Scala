package fi.kajstrom.efpscala.E18

import scala.io.StdIn._

object E18 extends App{
  val degType = promptType()
  val degreesInt = promptDegrees(degType)

  var degrees: Degrees = _
  if (degType == "C") {
    degrees = new Fahrenheit(degreesInt).toCelsius
  } else {
    degrees = new Celsius(degreesInt).toFahrenheit
  }

  println(s"The temperature in ${degrees.name} is ${degrees.deg}.")

  def promptType() : String = {
    println("Press C to convert from Fahrenheit to Celsius.")
    println("Press F to convert from Celsius to Fahrenheit.")
    readLine("Your choice: ").toUpperCase
  }
  def promptDegrees(degType: String) : Int = {
    if (degType == "C") {
      readLine("Please enter the temperature in Fahrenheit: ").toInt
    } else {
      readLine("Please enter the temperature in Celsius: ").toInt
    }
  }
}