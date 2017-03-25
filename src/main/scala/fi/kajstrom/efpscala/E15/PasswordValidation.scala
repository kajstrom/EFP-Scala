package fi.kajstrom.efpscala.E15

/**
  * Created by Kaitsu on 25.3.2017.
  */
class PasswordValidation {
  private var credentials: Map[String, String] = Map()

  def addUser(username: String, password: String) : Unit = credentials = credentials + (username -> password)
  def isValid(username: String, password: String) : Boolean = {
    if (credentials.contains(username)) {
      credentials(username) == password
    } else {
      false
    }
  }
}
