package fi.kajstrom.efpscala.E36Actor

import akka.actor.{Actor, ActorRef, Props}

import scala.collection.mutable

class StatisticsManager extends Actor {
  //I'm not really pleased with this solution of holding calculation responses.
  val requests = mutable.Map[Int, Vector[Any]]()
  val requestReturnAddresses = mutable.Map[Int, ActorRef]()

  val minimumCalculator = context.actorOf(Props(classOf[MinimumCalculator]), "minimumCalculator")
  val maximumCalculator = context.actorOf(Props(classOf[MaximumCalculator]), "maximumCalculator")
  val averageCalculator = context.actorOf(Props(classOf[AverageCalculator]), "averageCalculator")
  val standardDeviationCalculator = context.actorOf(Props(classOf[StandardDeviationCalculator]), "standardDeviationCalculator")

  def receive = {
    case request: RequestStatistics => {
      recordRequest(request, sender)

      minimumCalculator ! Calculate(request.requestId, request.numbers)
      maximumCalculator ! Calculate(request.requestId, request.numbers)
      averageCalculator ! Calculate(request.requestId, request.numbers)
      standardDeviationCalculator ! Calculate(request.requestId, request.numbers)
    }
    case min: MinimumCalculated => {
      recordResponse(min.requestId, min)

      if (isRequestComplete(min.requestId)) {
        self ! RequestReady(min.requestId)
      }
    }
    case max: MaximumCalculated => {
      recordResponse(max.requestId, max)

      if (isRequestComplete(max.requestId)) {
        self ! RequestReady(max.requestId)
      }
    }
    case avg: AverageCalculated => {
      recordResponse(avg.requestId, avg)

      if (isRequestComplete(avg.requestId)) {
        self ! RequestReady(avg.requestId)
      }
    }
    case stdDev: StandardDeviationCalculated => {
      recordResponse(stdDev.reguestId, stdDev)

      if (isRequestComplete(stdDev.reguestId)) {
        self ! RequestReady(stdDev.reguestId)
      }
    }
    case ready: RequestReady => {
      requestReturnAddresses(ready.requestId) ! statisticsCalculatedFor(ready.requestId)

      requestCompleted(ready.requestId)
    }
  }

  def recordRequest(request: RequestStatistics, sender: ActorRef): Unit = {
    requests(request.requestId) = Vector[Any]()
    requestReturnAddresses(request.requestId) = sender
  }

  def recordResponse(requestId: Int, result: Any): Unit = {
    if (requests.contains(requestId)) {
      requests.put(requestId, requests(requestId) :+ result)
    }
  }

  def requestCompleted(requestId: Int): Unit = {
    requests.remove(requestId)
    requestReturnAddresses.remove(requestId)
  }

  def isRequestComplete(requestId: Int): Boolean = requests(requestId).length == 4

  def statisticsCalculatedFor(requestId: Int): StatisticsCalculated = {
    var minimum = 0
    var maximum = 0
    var average = 0.0
    var standardDeviation = 0.0

    for (result <- requests(requestId)) {
      result match {
        case min: MinimumCalculated => minimum = min.minimum
        case max: MaximumCalculated => maximum = max.maximum
        case avg: AverageCalculated => average = avg.average
        case std: StandardDeviationCalculated => standardDeviation = std.standardDeviation
      }
    }

    StatisticsCalculated(
      requestId,
      minimum,
      maximum,
      average,
      standardDeviation
    )
  }
}

case class RequestStatistics(requestId: Int, numbers: Vector[Int])
case class Calculate(requestId: Int, numbers: Vector[Int])
case class RequestReady(requestId: Int)
case class StatisticsCalculated(
   requestId: Int,
   minimum: Int,
   maximum: Int,
   average: Double,
   standardDeviation: Double)
