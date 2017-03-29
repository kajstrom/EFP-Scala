package E19

import fi.kajstrom.efpscala.E19.BMI
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Kaitsu on 29.3.2017.
  */
class BMISpec extends FlatSpec with Matchers{
  it should "return 24.4 when height is 72 inches and weight is 180 pounds" in {
    val bmi = BMI(180, 72)

    bmi.bmi should equal(24.4)
  }

  it should "return true for oveweight when BMI is over 25" in {
    val bmi = BMI(200, 72)

    bmi.isOverweight should be(true)
    bmi.isUnderweight should be(false)
    bmi.isIdeal should be(false)
  }

  it should "return true for underweight when BMI is under 18.5" in {
    val bmi = BMI(120, 72)

    bmi.isUnderweight should be(true)
    bmi.isIdeal should be(false)
    bmi.isOverweight should be(false)
  }

  it should "return true for idead when BMI is between 18.5 and 25" in {
    val bmi = BMI(170, 72)

    bmi.isIdeal should be(true)
    bmi.isUnderweight should be(false)
    bmi.isOverweight should be(false)
  }
}
