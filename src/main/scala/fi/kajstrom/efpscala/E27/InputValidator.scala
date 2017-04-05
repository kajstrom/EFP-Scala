package fi.kajstrom.efpscala.E27

object InputValidator {
  def isValidName(name: String) : Boolean = name.length >= 2
  def isNameNotFilledIn(name: String) : Boolean = name.length == 0
  def isValidZIP(zip: String) : Boolean = zip.matches("[0-9]*")
  def isValidEmployeeId(id : String) : Boolean = id.matches("[A-Z]{2}\\-[0-9]{4}")
}
