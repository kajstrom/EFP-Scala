package fi.kajstrom.efpscala.E33

import scala.io.StdIn.readLine

object E33 extends App{
  //Magic eight ball does not do anything with the question...
  readLine("What's your question? ")

  val ball = new Magic8Ball

  println(ball.shake())
}
