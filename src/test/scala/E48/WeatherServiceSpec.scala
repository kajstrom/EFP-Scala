package E48

import fi.kajstrom.efpscala.E48.WeatherService
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Kaitsu on 5.5.2017.
  */
class WeatherServiceSpec extends FlatSpec with Matchers{
  it should "return weather for Vaasa when search string is Vaasa, FI" in {
    val ws = new WeatherService
    val weather = ws.forCity("Vaasa, FI")
    weather.city should be ("Vaasa")
  }
}
