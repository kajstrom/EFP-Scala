package fi.kajstrom.efpscala.E35Actor

import akka.actor.Actor
import scala.io.StdIn._
import scala.util.Random.nextInt

class WinnerPicker extends Actor{
  private var participants = Vector[String]()

  def receive = {
    case start: Start => self ! PromptName()
    case prompt: PromptName => {
      if (promptName()) {
        self ! PromptName()
      } else {
        self ! PickWinner()
      }
    }
    case pick: PickWinner => pickWinner()
  }

  def pickWinner(): Unit = {
    val winner = participants(nextInt(participants.length))

    println(s"The winner is... $winner")
  }

  def promptName(): Boolean = {
    val name = readLine("Enter name: ")

    if (name.length != 0 ) {
      participants = participants :+ name
      true
    } else {
      false
    }
  }
}

case class Start() {}
case class PromptName() {}
case class PickWinner() {}
