package E21

import fi.kajstrom.efpscala.E21.NumberCalendar
import org.scalatest.{FlatSpec, Matchers}

class NumberCalendarSpec extends FlatSpec with Matchers{
  it should "return name of the month for valid month numbers" in {
    NumberCalendar(1).monthName() should be ("January")
    NumberCalendar(6).monthName() should be ("June")
    NumberCalendar(12).monthName() should be ("December")
  }

  it should "throw IllegalArgumentException for a month that does not exist" in {
    an[IllegalArgumentException] should be thrownBy NumberCalendar(15).monthName()
  }
}
