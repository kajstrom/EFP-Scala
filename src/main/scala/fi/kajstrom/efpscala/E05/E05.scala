package fi.kajstrom.efpscala.E05
import scala.io.StdIn._

/**
  * Created by Kaitsu on 5.2.2017.
  */
object E05 extends App{

  val first = promptFirst()
  val second = promptSecond()

  val sm = new SimpleMath(first, second)

  output(sm)

  def promptFirst(): Int = readLine("What is the first number? ").toInt
  def promptSecond(): Int = readLine("What is the second number? ").toInt
  def output(sm: SimpleMath): Unit = {
    val results = s"${sm.x} + ${sm.y} = ${sm.plus()}\n" +
      s"${sm.x} - ${sm.y} = ${sm.minus()}\n" +
      s"${sm.x} * ${sm.y} = ${sm.multiply()}\n" +
      s"${sm.x} / ${sm.y} = ${sm.divide()}"

    println(results)
  }
}
