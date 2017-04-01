package fi.kajstrom.efpscala.E22

import scala.io.StdIn._

/**
  * Created by Kaitsu on 1.4.2017.
  */
object E22 extends App{

  val first = promptFirstNumber()
  val second = promptSecondNumber()
  val third = promptThirdNumber()

  val ln = LargestNumber(first, second, third)

  output(ln)

  def promptFirstNumber() : Int = readLine("Enter first number: ").toInt
  def promptSecondNumber() : Int = readLine("Enter second number: ").toInt
  def promptThirdNumber() : Int = readLine("Enter third number: ").toInt

  def output(ln: LargestNumber) : Unit = {
    if (ln.areAllEqual == false) {
      println(s"The largest number is ${ln.largest}")
    }
  }
}
