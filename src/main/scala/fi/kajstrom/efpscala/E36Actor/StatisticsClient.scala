package fi.kajstrom.efpscala.E36Actor

import akka.actor.{Actor, ActorRef}

import scala.io.StdIn.readLine

/**
  * Created by Kaitsu on 13.4.2017.
  */
class StatisticsClient(manager: ActorRef) extends Actor{
  var requests = 0

  def receive = {
    case start: Start => {
      requests += 1
      manager ! RequestStatistics(requests, promptNumbers())
      requests += 1
      manager ! RequestStatistics(requests, promptNumbers())
    }
    case statistics: StatisticsCalculated => {
      println(s"Results for request: ${statistics.requestId}")
      println(s"The average is ${statistics.average}.")
      println(s"The minimum is ${statistics.minimum}.")
      println(s"The maximum is ${statistics.maximum}.")
      println(s"The standard deviation is ${statistics.standardDeviation}")
    }
  }

  def promptNumbers(): Vector[Int] = {
    var numbers = Vector[Int]()
    var running = true

    while (running) {
      val input = readLine("Enter a number: ")

      if (input != "done") {
        try {
          numbers = numbers :+ input.toInt
        } catch {
          case nfe: NumberFormatException => println("That's not a valid number...")
          case _ => println("What seems to be the officer, problem?")
        }
      } else {
        running = false
      }
    }

    numbers
  }
}

case class Start()