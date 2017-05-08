package fi.kajstrom.efpscala.E50

import scala.io.StdIn._

object E50 extends App{
  val ms = new MovieService
  val movie = ms.findByName(readLine("Enter the name of a movie: "))

  println(s"Title: ${movie.title}")
  println(s"Year: ${movie.year}")
  println(s"Rating: ${movie.rating}")
  println(s"Running time: ${movie.runningTime} minutes")
  println(s"Description: ${movie.desc}")
}
