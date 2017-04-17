package fi.kajstrom.efpscala.E39

object E39 extends App{
  val employees = List(
    Map("first_name" -> "John", "last_name" -> "Johnson", "position" -> "Manager", "separation_date" -> "2016-12-31"),
    Map("first_name" -> "Tou", "last_name" -> "Xiong", "position" -> "Software Engineer", "separation_date" -> "2016-10-05"),
    Map("first_name" -> "Michaela", "last_name" -> "Michaelson", "position" -> "District Manager", "separation_date" -> "2015-12-09"),
    Map("first_name" -> "Jake", "last_name" -> "Jacobson", "position" -> "Programmer", "separation_date" -> null),
    Map("first_name" -> "Jacquelyn", "last_name" -> "Jackson", "position" -> "DBA", "separation_date" -> null),
    Map("first_name" -> "Sally", "last_name" -> "Weber", "position" -> "Web Developer", "separation_date" -> "2015-12-18")
  )

  println("Name                | Position          | Separation Date")
  println("--------------------|-------------------|----------------")

  employees.sortBy(_("last_name")).foreach((row: Map[String, String]) => {
    var nameColumn = row("first_name") + " " + row("last_name")
    nameColumn = nameColumn.padTo(20, " ").mkString + "| "

    var positionColumn = row("position").padTo(18, " ").mkString + "| "

    print(nameColumn)
    print(positionColumn)
    println(s"${row("separation_date")}")
    })


}
