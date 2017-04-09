package fi.kajstrom.efpscala.E31

/**
  * Created by Kaitsu on 9.4.2017.
  */
case class KarvonenFormula(age: Int, rhr: Int) {
  val ageAndRestingAdjustedHr = (220 - age) - rhr

  def forIntensity(intensity: Int) : Int = math.round((ageAndRestingAdjustedHr.toDouble * (intensity.toDouble / 100)) + rhr).toInt
}
