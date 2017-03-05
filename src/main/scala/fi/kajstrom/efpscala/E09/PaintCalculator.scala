package fi.kajstrom.efpscala.E09

/**
  * Created by Kaitsu on 5.3.2017.
  */
case class PaintCalculator(length: Int, width: Int) {
  val arePerGallon = 350
  val area = length * width

  def gallons: Int = Math.ceil(area.toDouble / arePerGallon.toDouble).toInt
}
