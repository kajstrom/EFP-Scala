package fi.kajstrom.efpscala.E43

/**
  * Created by Kaitsu on 23.4.2017.
  */
abstract class SiteComponent {
  def writeTo(folder: String): Boolean
}
