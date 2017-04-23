package fi.kajstrom.efpscala.E43

import java.io.{File, PrintWriter}

class HtmlFile(name: String, author: String, ds: String) extends SiteComponent{
  override def writeTo(folder: String): Boolean = {
    val filePath = folder + ds + name + ".html"

    val file = new File(folder + ds + name + ".html")
    try {
      val pw = new PrintWriter(file)

      pw.write(s"<html>" +
        s"<head>" +
        s"<title>$name</title>" +
        s"<meta author'$author'>" +
        s"</head>" +
        s"</html>")

      pw.close()

      println(s"Created $filePath")
      true
    } catch {
      case _: Exception => false
    }
  }
}
