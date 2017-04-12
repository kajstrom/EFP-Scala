package fi.kajstrom.efpscala.E35

import scala.io.StdIn._
import scala.util.Random.nextInt

object E35 extends App{
  var participants = Vector[String]()

  start()

  def start(): Unit = {
    var running = true

    while(running) {
      val name = readLine("Enter a name: ")

      if (name.length != 0) {
        participants = participants :+ name
      } else {
        running = false

        val winner = participants(nextInt(participants.length))

        println(s"The winner is... $winner")
      }
    }
  }
}
