package E18

import fi.kajstrom.efpscala.E18.{Celsius, Fahrenheit}
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Kaitsu on 28.3.2017.
  */
class TemperatureConverterSpec extends FlatSpec with Matchers{
  it should "return 0 degrees Celsius with 32 Fahrenheit degrees" in {
    val fahrenheit = new Fahrenheit(32)

    fahrenheit.toCelsius.deg should equal(0)
  }

  it should "return 32 degrees Fahrenheit with 0 Celsius degrees" in {
    val celsius = new Celsius(0)

    celsius.toFahrenheit.deg should equal(32)
  }
}
