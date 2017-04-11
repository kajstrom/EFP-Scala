package fi.kajstrom.efpscala.E34

import scala.io.StdIn.readLine

object E34 extends App{
  val employeeManager = new EmployeeManager

  outputEmployees(employeeManager.getEmployees)

  val employeeToRemove = readLine("Enter an employee name to remove: ")

  employeeManager.remove(employeeToRemove)

  outputEmployees(employeeManager.getEmployees)

  def outputEmployees(employees: Vector[String]): Unit = {
    println(s"There are ${employees.length} employees")
    employees.foreach(println(_))
  }
}
