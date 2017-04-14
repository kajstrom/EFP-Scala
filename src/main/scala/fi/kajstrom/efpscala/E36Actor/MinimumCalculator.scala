package fi.kajstrom.efpscala.E36Actor

import akka.actor.Actor

/**
  * Created by Kaitsu on 13.4.2017.
  */
class MinimumCalculator() extends Actor
{
  def receive = {
    case calculate: Calculate => {
      context.parent ! MinimumCalculated(calculate.requestId, calculate.numbers.min)
    }
  }
}

case class MinimumCalculated(requestId: Int, minimum: Int)
