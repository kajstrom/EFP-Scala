package fi.kajstrom.efpscala.E22

/**
  * Created by Kaitsu on 1.4.2017.
  */
case class LargestNumber(first: Int, second: Int, third: Int) {
  def areAllEqual: Boolean = (first == second) && (second == third)

  def largest: Int = {
    if (first > second) {
      if (first > third) {
        first
      } else {
        third
      }
    } else if (second > third) {
      second
    } else {
      third
    }
  }
}
