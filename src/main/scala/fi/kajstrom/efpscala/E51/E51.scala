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
  val nc = new NotebookController(fs)

  nc.console()
}
