package fi.kajstrom.efpscala.E40

import scala.io.StdIn._

object E40 extends App {
  val employees = List(
    Map("first_name" -> "John", "last_name" -> "Johnson", "position" -> "Manager", "separation_date" -> "2016-12-31"),
    Map("first_name" -> "Tou", "last_name" -> "Xiong", "position" -> "Software Engineer", "separation_date" -> "2016-10-05"),
    Map("first_name" -> "Michaela", "last_name" -> "Michaelson", "position" -> "District Manager", "separation_date" -> "2015-12-09"),
    Map("first_name" -> "Jake", "last_name" -> "Jacobson", "position" -> "Programmer", "separation_date" -> null),
    Map("first_name" -> "Jacquelyn", "last_name" -> "Jackson", "position" -> "DBA", "separation_date" -> null),
    Map("first_name" -> "Sally", "last_name" -> "Weber", "position" -> "Web Developer", "separation_date" -> "2015-12-18")
  )

  val filterText = readLine("Enter a search string: ")

  println("Name                | Position          | Separation Date")
  println("--------------------|-------------------|----------------")

  employees
    .filter((employee: Map[String, String]) => {
      val filterLength = filterText.length

      if (filterLength <= employee("first_name").length) {
        employee("first_name").substring(0, filterText.length).toLowerCase == filterText.toLowerCase
      } else {
        false
      }
    })
    .foreach((row: Map[String, String]) => {
      var nameColumn = row("first_name") + " " + row("last_name")
      nameColumn = nameColumn.padTo(20, " ").mkString + "| "

      var positionColumn = row("position").padTo(18, " ").mkString + "| "

      print(nameColumn)
      print(positionColumn)
      println(s"${row("separation_date")}")
  })
}
