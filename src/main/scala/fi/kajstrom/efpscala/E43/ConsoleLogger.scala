package fi.kajstrom.efpscala.E43

object ConsoleLogger extends Logger{
  override def log(entry: String): Unit = println(entry)
}
