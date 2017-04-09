package fi.kajstrom.efpscala.E31

import scala.io.StdIn._

object E31 extends App{
  val kf = KarvonenFormula(
    promptAge(),
    promptRHR()
  )

  outputTable(kf)

  def promptAge(): Int = readLine("Enter age: ").toInt
  def promptRHR(): Int = readLine("Enter RHR: ").toInt

  def outputTable(kf: KarvonenFormula) : Unit = {
    println(s"Resting Pulse: ${kf.rhr}   Age: ${kf.age}")
    println(" ")
    println("Intensity | Rate")
    println("----------|------")
    var intensity = 0
    for (intensity <- 55 to 95 by 5) {
      println(s"$intensity%       | ${kf.forIntensity(intensity)} bpm")
    }
  }
}
