package fi.kajstrom.efpscala.E19

import scala.io.StdIn._

/**
  * Created by Kaitsu on 29.3.2017.
  */
object E19 extends App{

  val bmi = BMI(
    promptWeight(),
    promptHeight()
  )

  output(bmi)

  def promptWeight(): Int = {
    try {
      readLine("Enter your weight: ").toInt
    } catch {
      case nfe: NumberFormatException => {
        println("Please enter a numeric value...")
        promptWeight()
      }
    }
  }
  def promptHeight(): Int = {
    try {
      readLine("Enter your height: ").toInt
    } catch {
      case nfe: NumberFormatException => {
        println("Please enter a numeric value...")
        promptHeight()
      }
    }
  }

  def output(bmi: BMI) : Unit = {
    println(s"Your BMI is ${bmi.bmi}")
    if (bmi.isIdeal) {
      println("You are within the ideal weight range.")
    } else if(bmi.isUnderweight) {
      println("You are underweight. You should see a doctor.")
    } else if(bmi.isOverweight) {
      println("You are overweight. You should see a doctor.")
    }
  }
}
