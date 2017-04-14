package fi.kajstrom.efpscala.E36Actor

import akka.actor.{ActorSystem, Props}

/**
  * The purpose of this version of Exercise 36 is to try out messaging pattern with Akka, Scatter-Gather.
  */
object E36Actor extends App{
  val system = ActorSystem("E36Actor")

  val statisticsManager = system.actorOf(Props[StatisticsManager], "statisticsManager")
  val statisticsClient = system.actorOf(Props(classOf[StatisticsClient], statisticsManager), "statisticsCalculator")

  statisticsClient ! Start()
}
