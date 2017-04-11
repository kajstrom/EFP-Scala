package fi.kajstrom.efpscala.E34

/**
  * Created by Kaitsu on 11.4.2017.
  */
class EmployeeManager {
  private var employees = Vector(
    "John Smith",
    "Jackie Jackson",
    "Chris Jones",
    "Amanda Cullen",
    "Jeremy Goodwin"
  )

  def remove(name: String): Unit = {
    if (employees.contains(name)) {
      employees = employees.filter(_ != name)
    }
  }

  def getEmployees: Vector[String] = employees
}
