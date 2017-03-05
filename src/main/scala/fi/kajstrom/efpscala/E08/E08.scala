package fi.kajstrom.efpscala.E08

import scala.io.StdIn._
/**
  * Created by Kaitsu on 5.3.2017.
  */
object E08 extends App{

  val slicer = new PizzaSlicer(
    promptPeople(),
    promptPizzas(),
    promptSlicesPerPizza()
  )

  outputResult(slicer)

  def promptPeople(): Int = readLine("How many people? ").toInt
  def promptPizzas(): Int = readLine("How many pizzas do you have? ").toInt
  def promptSlicesPerPizza(): Int = readLine("How many slices per pizza? ").toInt
  def outputResult(slicer: PizzaSlicer): Unit = {
    println(s"${slicer.people} people with ${slicer.pizzas} pizzas")
    println(s"Each person gets ${slicer.slicesPerPerson()} of pizza")
    println(s"There are ${slicer.leftovers()} leftover pieces")
  }
}
