package fi.kajstrom.efpscala.E33Actor

import akka.actor.{Actor, PoisonPill}

import scala.util.Random.nextInt

/**
  * Created by Kaitsu on 11.4.2017.
  */
class Magic8Ball extends Actor{
  val answers = Vector("Yes", "No", "Maybe", "Ask again later")

  def receive = {
    case shake: Shake => {
      sender ! BallShaked(answers(nextInt(answers.length)))
    }
    case _ => {
      println("Unkown message received")
    }
  }
}

case class Shake(question: String){}
case class BallShaked(result: String)