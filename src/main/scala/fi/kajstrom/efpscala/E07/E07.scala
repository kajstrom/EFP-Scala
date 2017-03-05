package fi.kajstrom.efpscala.E07

import scala.io.StdIn._
/**
  * Created by Kaitsu on 15.2.2017.
  */
object E07 extends App{

  val length = promptLength()
  val width = promptWidth()

  outputResults(new RoomArea(length, width))

  def promptLength(): Int = {
    try {
      readLine("What is the length of the room in feet? ").toInt
    }
    catch {
      case nfe: NumberFormatException => {
        println("Value is not numeric! Please re-enter")
        promptLength()
      }
    }
  }
  def promptWidth(): Int = {
    try {
      readLine("What is the width of the room in feet? ").toInt
    } catch {
      case nef: NumberFormatException => {
        println("Value is not numeric! Please re-enter")
        promptWidth()
      }
    }
  }
  def outputResults(roomArea: RoomArea): Unit = {
    println("The area is")
    println(s"${roomArea.areaFeet()} square feet")
    println(s"${roomArea.areaMeters()} square meters")
  }
}
