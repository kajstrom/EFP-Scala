package fi.kajstrom.efpscala.E16

class DrivingAgeChecker {
  val legalDrivingAge = 16

  def oldEnoughToDrive(age: Int) : Boolean = age >= legalDrivingAge
}
