package fi.kajstrom.efpscala.E18

abstract class Degrees() {
  val name: String
  val deg: Int
  def toCelsius : Celsius
  def toFahrenheit : Fahrenheit
}

class Fahrenheit(degrees: Int) extends Degrees{
  val name = "Fahrenheit"
  val deg: Int = degrees

  def toCelsius: Celsius = new Celsius(BigDecimal((degrees - 32) * 5.0/9.0).setScale(0, BigDecimal.RoundingMode.HALF_UP).toInt)
  def toFahrenheit : Fahrenheit = this
}

class Celsius(degrees: Int) extends Degrees{
  val name  = "Celsius"
  val deg: Int = degrees

  def toCelsius: Celsius = this
  def toFahrenheit : Fahrenheit = new Fahrenheit(BigDecimal((degrees * 9.0/5.0) + 32).setScale(0, BigDecimal.RoundingMode.HALF_UP).toInt)
}