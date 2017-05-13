package fi.kajstrom.efpscala.E51

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import play.api.libs.ws.ahc.AhcWSClient

import scala.io.StdIn._

object E51 extends App {
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  val ws = AhcWSClient()

  val fs = new FirebaseService(ws)

  val notebook = readLine("Enter notebook name: ")
  val note = readLine("Enter note to save: ")

  val success = fs.addNote(notebook, note)

  if (success) {
    println("Your note was saved.")
    ws.close()
    system.terminate()
  }
}
