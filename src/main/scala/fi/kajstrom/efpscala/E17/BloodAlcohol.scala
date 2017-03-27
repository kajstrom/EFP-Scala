package fi.kajstrom.efpscala.E17

case class BloodAlcohol(alcoholOunces: Double, weight: Int, sex: String, hoursSinceLastDrink: Int) {
  val legalBACLimit = 0.08

  def alcoholDistributionRation(): Double = if (sex == "m") 0.73 else 0.66

  def bac(): Double = {
    val bac = ((alcoholOunces * 5.14) / (weight * alcoholDistributionRation())) - (0.015 * hoursSinceLastDrink)

    BigDecimal(bac).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
  }

  def legalToDrive(): Boolean = bac < legalBACLimit
}
