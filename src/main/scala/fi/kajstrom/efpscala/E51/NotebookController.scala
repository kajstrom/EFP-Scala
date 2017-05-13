package fi.kajstrom.efpscala.E51

import scala.io.StdIn._

class NotebookController(firebaseService: FirebaseService) {
  def console(): Unit = {
    val commandWithParameters = readLine()
    val splitted = commandWithParameters.split(" ").map(_.mkString)
    println(splitted)

    val notebook = splitted(0)
    val command = splitted(1)

    if (command == "new") {
      add(notebook, splitted.slice(2, splitted.length).mkString(" "))
    } else if (command == "show") {
      show(notebook)
    }
  }

  private def add(notebook: String, note: String): Unit = {
    val success = firebaseService.addNote(notebook, note)

    if (success) {
      println("Your note was saved.")
    } else {
      println("Error saving note.")
    }

    console()
  }

  private def show(notebook: String): Unit = {
    firebaseService
      .getNotesFrom(notebook)
      .foreach((note: (String,Map[String, String])) => {
      println(note._1 + " - " + note._2("content"))
    })
  }
}
