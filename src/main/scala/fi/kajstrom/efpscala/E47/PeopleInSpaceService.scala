package fi.kajstrom.efpscala.E47

import play.api.libs.json._
import play.api.libs.functional.syntax._

class PeopleInSpaceService {
  def people: List[Person] = {
    val peopleJson = retrievePeopleJSON()

    implicit val personReads: Reads[Person] =(
      (__ \ "name").read[String] and
      (__ \ "craft").read[String]
    )(Person)

    val json = Json.parse(peopleJson)

    val peopleResultList = (json \ "people")
    val people = peopleResultList.validate[List[Person]]

    val peopleList = people match {
      case s: JsSuccess[List[Person]] => s.get
    }

    peopleList
  }

  private def retrievePeopleJSON(): String = {
    import java.net.{URL, HttpURLConnection}
    val connection = new URL("http://api.open-notify.org/astros.json").openConnection.asInstanceOf[HttpURLConnection]

    connection.setConnectTimeout(3000)
    connection.setReadTimeout(3000)
    connection.setRequestMethod("GET")

    val inputStream = connection.getInputStream
    val content = scala.io.Source.fromInputStream(inputStream).mkString

    if (inputStream != null) inputStream.close()

    content
  }
}

case class Person(name: String, craft: String)
