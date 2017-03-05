package fi.kajstrom.efpscala.E06

import java.time.LocalDate

class RetirementCalculator(currentYear: Int) {
  def yearToRetire(age: Int, retirementAge: Int): Int = currentYear + (retirementAge - age)
  def yearsToRetirement(age: Int, retirementAge: Int): Int = retirementAge - age
}
