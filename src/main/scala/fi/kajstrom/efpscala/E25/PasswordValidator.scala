package fi.kajstrom.efpscala.E25

/**
  * Heavy regular expression usage. I'd be damned if this didn't contain any bugs... :)
  */

class PasswordValidator {
  def validate(password: String) : Int = {
    var passwordStrength = 0
    if (password.length < 8 && password.matches("[0-9]*")) {
      passwordStrength = 1
    } else if (password.length < 8 && password.matches("[a-zA-Z]*")) {
      passwordStrength = 2
    } else if (password.length >= 8 && password.matches(".*[0-9]{1,}.*[a-zA-Z]{1,}.*[^a-zA-Z0-9]{1,}.*")) {
      passwordStrength = 4
    } else if (password.length >= 8 && password.matches(".*[0-9]{1,}.*[a-zA-Z]{1,}.*")) {
      passwordStrength = 3
    }

    passwordStrength
  }
}
