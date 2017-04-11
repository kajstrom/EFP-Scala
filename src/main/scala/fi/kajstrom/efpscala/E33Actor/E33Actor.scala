package fi.kajstrom.efpscala.E33Actor

import akka.actor.{ActorSystem, Props}

/**
  * Created by Kaitsu on 11.4.2017.
  */
object E33Actor extends App{
  val system = ActorSystem("8Ball")
  val magic8Ball = system.actorOf(Props[Magic8Ball], "8ball")
  val shaker = system.actorOf(Props(classOf[BallShaker], magic8Ball))

  shaker ! Start()
}
