package fi.kajstrom.efpscala.E43

object NullLogger extends Logger{
  override def log(entry: String): Unit = {
    //Null logger does nothing.
  }
}
