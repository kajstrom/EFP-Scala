package fi.kajstrom.efpscala.E03

/**
  * Created by Kaitsu on 19.1.2017.
  */
class Quoter {
  def quote(quotation: String, from: String): String = {
    from + " says, \"" + quotation + "\""
  }
}
