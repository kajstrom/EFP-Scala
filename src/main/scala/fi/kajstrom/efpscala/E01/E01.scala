package fi.kajstrom.efpscala.E01

/**
  * Created by Kaitsu on 8.1.2017.
  */
object E01 {
  def main(args: Array[String]) = {
    val greeter = new Greeter()

    val name = promptName

    println(greeter greet name)
  }

  def promptName = {
    println("What is your name? ");
    scala.io.StdIn.readLine()
  }
}
