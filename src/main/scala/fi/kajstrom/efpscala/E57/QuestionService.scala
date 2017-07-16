package fi.kajstrom.efpscala.E57

import fi.kajstrom.efpscala.Util.FilePath
import play.api.libs.json.{JsError, JsSuccess, Json}

import scala.io.Source

class QuestionService(filename: String) {

  def getQuestions: Seq[Question] = {
    val pathString = FilePath.makeResourcePath(filename)
    val jsonString = Source.fromFile(pathString).mkString
    val json = Json.parse(jsonString)

    json.validate[Seq[Question]] match {
      case s: JsSuccess[Seq[Question]] => s.get
      case e: JsError => Seq()
    }
  }
}
