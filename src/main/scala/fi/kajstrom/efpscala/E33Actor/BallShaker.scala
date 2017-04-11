package fi.kajstrom.efpscala.E33Actor

import akka.actor.{Actor, ActorRef}

import scala.io.StdIn._


class BallShaker(ball: ActorRef) extends Actor{
  def receive = {
    case start: Start => {
      val q = readLine("What's your question?")
      ball ! Shake(q)
    }
    case shaked: BallShaked => println(shaked.result)
  }
}

case class Start()
