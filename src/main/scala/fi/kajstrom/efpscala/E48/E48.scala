package fi.kajstrom.efpscala.E48

import scala.io.StdIn._

object E48 extends App{
  val ws = new WeatherService

  val city = readLine("Where are you? ")

  val weather = ws.forCity(city)

  println(s"${weather.city} weather: ")
  println(s"${weather.temp} degress Celsius")
}
