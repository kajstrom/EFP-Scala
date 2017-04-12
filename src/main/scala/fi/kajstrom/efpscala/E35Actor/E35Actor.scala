package fi.kajstrom.efpscala.E35Actor

import akka.actor.{ActorSystem, Props}

object E35Actor extends App{
  val system = ActorSystem("E35Actor")

  val picker = system.actorOf(Props[WinnerPicker])

  picker ! Start()
}
