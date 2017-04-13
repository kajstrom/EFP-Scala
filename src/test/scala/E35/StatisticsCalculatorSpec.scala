package E35

import fi.kajstrom.efpscala.E36.StatisticsCalculator
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Kaitsu on 13.4.2017.
  */
class StatisticsCalculatorSpec extends FlatSpec with Matchers{
  val sc = new StatisticsCalculator()
  val numbers = Vector(100, 200, 1000, 300)
  val statistics = sc.calculate(numbers)

  it should "return 400 as the average" in {
    statistics.average should equal(400)
  }

  it should "return 100 as the minimum" in {
    statistics.minimum should equal(100)
  }

  it should "return 1000 as the maximum" in {
    statistics.maximum should equal(1000)
  }

  //This is probably population standard deviation and not sample standard deviation
  it should "return 353.55 as te standard deviation" in {
    statistics.standardDeviation should equal(353.55)
  }
}
