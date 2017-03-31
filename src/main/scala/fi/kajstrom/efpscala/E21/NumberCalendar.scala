package fi.kajstrom.efpscala.E21

/**
  * Created by Kaitsu on 31.3.2017.
  */
case class NumberCalendar(numberOfMonth: Int) {
  val months: Map[Int, String] = Map(
    1 -> "January",
    2 -> "February",
    3 -> "March",
    4 -> "April",
    5 -> "May",
    6 -> "June",
    7 -> "July",
    8 -> "August",
    9 -> "September",
    10 -> "October",
    11 -> "November",
    12 -> "December"
  )

  def monthName() : String = {
    if (months contains(numberOfMonth)) {
      months(numberOfMonth)
    } else {
      throw new IllegalArgumentException(s"There is no month with number ${numberOfMonth}")
    }
  }
}
