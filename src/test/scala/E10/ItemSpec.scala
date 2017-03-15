package E10

import fi.kajstrom.efpscala.E10.Item
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Kaitsu on 6.3.2017.
  */
class ItemSpec extends FlatSpec with Matchers{
  val item = new Item(5, 4)

  it should "return 20 as tax free total with 4 items priced $5 each" in {
      item.total() should equal(20)
  }

  it should "return 1.1 as tax for 4 items priced $5 each" in {
    item.tax() should equal(1.10)
  }
}
