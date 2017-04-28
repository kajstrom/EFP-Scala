package fi.kajstrom.efpscala.E43

import java.io.File

import fi.kajstrom.efpscala.Util.FilePath

import scala.io.StdIn._

object E43 extends App {

  val siteName = readLine("Site name: ")
  val author = readLine("Author: ")
  val jsFolder = readLine("Do you want a folder for JavaScript?").toLowerCase == "y"
  val cssFolder = readLine("Do you want a folder for CSS?").toLowerCase == "y"

  val siteFolder = new Folder(ConsoleLogger, siteName, FilePath.ds)

  if (jsFolder) {
    siteFolder.addComponent(new Folder(ConsoleLogger, "js", FilePath.ds))
  }

  if (cssFolder) {
    siteFolder.addComponent(new Folder(ConsoleLogger, "css", FilePath.ds))
  }

  siteFolder.addComponent(new HtmlFile(ConsoleLogger, "index", author, FilePath.ds))

  siteFolder.writeTo(FilePath.resourcesPath)
}
