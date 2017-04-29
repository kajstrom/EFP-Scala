package fi.kajstrom.efpscala.E45

import java.io.{File, FileNotFoundException, PrintWriter}

import fi.kajstrom.efpscala.Util.FilePath

import scala.io.StdIn._
import scala.io.Source

object E45 extends App{
  val replaceWord = readLine("Enter word to replace: ")
  val replaceWith = readLine(s"Replace '$replaceWord' with: ")

  val modifiedContents = replaceInFile(replaceWord, replaceWith)

  print("Replace result: ")
  println(modifiedContents)

  val saveToFile = readLine("Enter filename to save into: ")
  val saveFilePath = FilePath.makeResourcePath(saveToFile)


  try {
    writeModifiedToFile(saveToFile)
    println(s"File saved: $saveFilePath")
  } catch {
    case notFound: FileNotFoundException => println(s"Couldn't write to $saveFilePath: ${notFound.getMessage}")
  }

  private def replaceInFile(find: String, replace: String) : String = {
    val fileContents = Source.fromFile(FilePath.makeResourcePath("E45_in.txt")).mkString
    fileContents.replaceAll(replaceWord, replaceWith)
  }

  private def writeModifiedToFile(saveToFile: String) = {
      val saveFile = new File(saveFilePath)

      val pw = new PrintWriter(saveFile)
      pw.write(modifiedContents)
      pw.close()
  }
}
