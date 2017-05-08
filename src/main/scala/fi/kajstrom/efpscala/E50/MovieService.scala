package fi.kajstrom.efpscala.E50

import java.net.URLEncoder

class MovieService {
  def findByName(name: String): Movie = {
    val urlEncodedName = URLEncoder.encode(name, "UTF-8")
    //println(retrieveMovieJSON(urlEncodedName))

    //Return dummy data as Rotten Tomatoes API shows my user account as inactive still.
    Movie("The Movie", 2017, "PG-13", 120, "Dummy movie to implement the CLI part of the application as " +
      "the API is not working for me yet...")
  }

  private def retrieveMovieJSON(query: String): String = {
    import java.net.{URL, HttpURLConnection}
    val connection = new URL(s"http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey=mg8jqzehw3jj52shbv8uj2bg&q=$query&page_limit=1&page=1").openConnection.asInstanceOf[HttpURLConnection]

    connection.setConnectTimeout(3000)
    connection.setReadTimeout(3000)
    connection.setRequestMethod("GET")

    val inputStream = connection.getInputStream
    val content = scala.io.Source.fromInputStream(inputStream).mkString

    if (inputStream != null) inputStream.close()

    content
  }
}

case class Movie(title: String, year: Int, rating: String, runningTime: Int, desc: String)
