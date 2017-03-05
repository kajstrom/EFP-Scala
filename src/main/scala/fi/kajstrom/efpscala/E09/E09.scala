package fi.kajstrom.efpscala.E09

import scala.io.StdIn._
/**
  * Created by Kaitsu on 5.3.2017.
  */
object E09 extends App{
  val paint = new PaintCalculator(
    promptLength(),
    promptWidth()
  )

  outputResult(paint)

  def promptLength(): Int = readLine("Enter ceiling length: ").toInt
  def promptWidth(): Int = readLine("Enter ceiling width: ").toInt
  def outputResult(paint: PaintCalculator): Unit = {
    println(s"You will need to purchase ${paint.gallons} gallons of paint to cover ${paint.area} square feet")
  }
}
