package fi.kajstrom.efpscala.E36Actor

import akka.actor.Actor

class AverageCalculator extends Actor{
  def receive = {
    case calculate: Calculate => {
      context.parent ! AverageCalculated(calculate.requestId, calculate.numbers.sum / calculate.numbers.length)
    }
  }
}

case class AverageCalculated(requestId: Int, average: Int)
