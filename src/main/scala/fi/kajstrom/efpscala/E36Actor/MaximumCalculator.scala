package fi.kajstrom.efpscala.E36Actor

import akka.actor.Actor

class MaximumCalculator extends Actor{
  def receive = {
    case calculate: Calculate => {
      context.parent ! MaximumCalculated(calculate.requestId, calculate.numbers.max)
    }
  }
}

case class MaximumCalculated(requestId: Int, maximum: Int)
