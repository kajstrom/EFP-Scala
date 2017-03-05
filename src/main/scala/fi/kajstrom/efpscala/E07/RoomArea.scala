package fi.kajstrom.efpscala.E07

/**
  * Created by Kaitsu on 15.2.2017.
  */
case class RoomArea(length: Int, width: Int) {
  val feetToMeters: Double = 0.09290304

  def areaFeet(): Double = length * width
  def areaMeters(): Double = areaFeet() * feetToMeters
}
