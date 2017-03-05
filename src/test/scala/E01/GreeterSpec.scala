package E01

import fi.kajstrom.efpscala.E01.Greeter
import org.scalatest._

/**
  * Created by Kaitsu on 15.1.2017.
  */
class GreeterSpec extends FlatSpec with Matchers {
  "greet" should "return properly formatted greeting" in {
    val greeter = new Greeter()
    greeter.greet("Kaj") should be ("Hello, Kaj, nice to meet you!")
  }
}
