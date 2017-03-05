package E05

import fi.kajstrom.efpscala.E05.SimpleMath
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Kaitsu on 5.2.2017.
  */
class SimpleMathSpec extends FlatSpec with Matchers{
  val sm = new SimpleMath(2, 2)

  "plus" should "return x + y" in {
    sm.plus should be (4)
  }

  "minus" should "return x - y" in {
    sm.minus should be (0)
  }

  "multiply" should "return x * y" in {
    sm.multiply should be(4)
  }

  "divide" should "return x / y" in {
    sm.divide should be(1)
  }
}
