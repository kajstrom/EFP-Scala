package fi.kajstrom.efpscala.E48

import play.api.libs.json.{JsValue, Json}

class WeatherService {
  def forCity(city: String) : Weather = {
    val weatherJSON = retrieveWeatherJSON(city)

    val json : JsValue = Json.parse(weatherJSON)
    val temperature = (json \ "main" \ "temp").as[Double]
    val name = (json \ "name").as[String]

    Weather(name, temperature)
  }

  private def retrieveWeatherJSON(query: String): String = {
    import java.net.{URL, HttpURLConnection}
    val connection = new URL(s"http://api.openweathermap.org/data/2.5/weather?q=$query&appid=eded185ba4eb988918dfbcaf8319e171&units=metric").openConnection.asInstanceOf[HttpURLConnection]

    connection.setConnectTimeout(3000)
    connection.setReadTimeout(3000)
    connection.setRequestMethod("GET")

    val inputStream = connection.getInputStream
    val content = scala.io.Source.fromInputStream(inputStream).mkString

    if (inputStream != null) inputStream.close()

    content
  }
}

case class Weather(city: String, temp: Double)
