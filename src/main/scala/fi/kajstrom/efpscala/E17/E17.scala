package fi.kajstrom.efpscala.E17

import scala.io.StdIn._

object E17 extends App{

  val bac = BloodAlcohol(
    promptAlcoholConsumed(),
    promptWeight(),
    promptSex(),
    promptHoursSinceLastDrink()
  )

  output(bac)

  def promptAlcoholConsumed() : Double = {
    try {
      val numberOfDrinks = readLine("Enter volume of drinks: ").toInt
      val alcVol = readLine("Enter alcohol content by volume: ").toDouble

      numberOfDrinks * (alcVol / 100)
    } catch {
      case nf: NumberFormatException => {
        println("Please enter a valid numeric value...")
        promptAlcoholConsumed()
      }
    }
  }
  def promptWeight() : Int = {
    try {
      readLine("Enter weight: ").toInt
    } catch {
      case nf: NumberFormatException => {
        println("Please enter a valid numeric value...")
        promptWeight()
      }
    }
  }
  def promptHoursSinceLastDrink() : Int = {
    try {
      readLine("Enter hours passed since last drink: ").toInt
    } catch {
      case nf: NumberFormatException => {
        println("Please enter a valid numeric value...")
        promptHoursSinceLastDrink()
      }
    }
  }

  def promptSex() : String = readLine("Enter sex(m/f): ")

  def output(bac: BloodAlcohol) : Unit = {
    println(f"Your BAC is ${bac.bac()}%.2f")
    if (bac.legalToDrive()) {
      println("It is legal for you to drive")
    } else {
      println("It is not legal for you to drive")
    }
  }
}
