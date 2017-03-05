package E07

import fi.kajstrom.efpscala.E07.RoomArea
import org.scalactic.TolerantNumerics
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Kaitsu on 15.2.2017.
  */
class RoomAreaSpec extends FlatSpec with Matchers{
  implicit val doubleEq = TolerantNumerics.tolerantDoubleEquality(0.001)
  val room = new RoomArea(15, 20)

  "areaFeet" should "return 300 when size is 15 x 20 feet" in {
    room.areaFeet() should be (300)
  }

  "areaMeters" should "return 27.871 when size is 15 x 20 feet" in {
    assert(room.areaMeters() === 27.871)
  }
}
