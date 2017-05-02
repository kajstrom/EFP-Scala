package E44

import fi.kajstrom.efpscala.E44.ProductGateway
import org.scalatest._

/**
  * Created by Kaitsu on 2.5.2017.
  */
class ProductGatewaySpec extends FlatSpec with Matchers{
  val pg = new ProductGateway

  it should "return right Product when searching with existing name" in {
    pg.findByName("Widget").get.name should be("Widget")
  }

  it should "return None when searching with non-existing name" in {
    pg.findByName("NoSuchName") should be(None)
  }
}
