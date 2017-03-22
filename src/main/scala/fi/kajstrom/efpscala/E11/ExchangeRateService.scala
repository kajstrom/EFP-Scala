package fi.kajstrom.efpscala.E11

import play.api.libs.json._


class ExchangeRateService {
  def rateFor(fromCurrency: String, toCurrency: String) : ExchangeRate = {
    val rawJSON = retrieveRates()

    val json : JsValue = Json.parse(rawJSON)
    val rate = (json \ "rates" \ toCurrency).as[Double]

    ExchangeRate(fromCurrency, toCurrency, rate)
  }

  private def retrieveRates(): String = {
    import java.net.{URL, HttpURLConnection}
    val connection = new URL(s"https://openexchangerates.org/api/latest.json?app_id=26b8a524801d4d1a92d1159dffe505fa").openConnection.asInstanceOf[HttpURLConnection]

    connection.setConnectTimeout(3000)
    connection.setReadTimeout(3000)
    connection.setRequestMethod("GET")

    val inputStream = connection.getInputStream
    val content = scala.io.Source.fromInputStream(inputStream).mkString

    if (inputStream != null) inputStream.close()

    content
  }
}
