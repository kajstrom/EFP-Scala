package fi.kajstrom.efpscala.E19

/**
  * Created by Kaitsu on 29.3.2017.
  */
case class BMI(weight: Int, heightInInches: Int) {
  val underweightLimit = 18.5
  val overweightLimit = 25.0

  def bmi : Double = {
    val bmi = (weight / (heightInInches.toDouble * heightInInches)) * 703

    BigDecimal(bmi).setScale(1, BigDecimal.RoundingMode.HALF_UP).toDouble
  }

  def isUnderweight: Boolean = bmi < underweightLimit
  def isIdeal: Boolean = bmi >= underweightLimit && bmi <= overweightLimit
  def isOverweight: Boolean = bmi > overweightLimit
}
