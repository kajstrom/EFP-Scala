package fi.kajstrom.efpscala.E43

import java.io.File

import scala.io.StdIn._

object E43 extends App {
  val projectRoot = new File(".").getCanonicalPath
  val ds = File.separator
  val resources = projectRoot + ds + "resources"

  val siteName = readLine("Site name: ")
  val author = readLine("Author: ")
  val jsFolder = readLine("Do you want a folder for JavaScript?").toLowerCase == "y"
  val cssFolder = readLine("Do you want a folder for CSS?").toLowerCase == "y"

  val siteFolder = new Folder(ConsoleLogger, siteName, ds)

  if (jsFolder) {
    siteFolder.addComponent(new Folder(ConsoleLogger, "js", ds))
  }

  if (cssFolder) {
    siteFolder.addComponent(new Folder(ConsoleLogger, "css", ds))
  }

  siteFolder.addComponent(new HtmlFile(ConsoleLogger, "index", author, ds))

  siteFolder.writeTo(resources)
}