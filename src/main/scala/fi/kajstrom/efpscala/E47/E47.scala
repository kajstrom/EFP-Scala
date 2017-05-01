package fi.kajstrom.efpscala.E47

object E47 extends App{
  val sg = new PeopleInSpaceService
  val people = sg.people

  println(s"There are ${people.length} people in space right now:")

  print("Name".padTo(20, " ").mkString)
  println("| Craft")
  print("".padTo(20, "-").mkString)
  println("|------")

  people.foreach((p: Person) => {
    print(p.name.padTo(20, " ").mkString)
    println("| " + p.craft)
  })
}
