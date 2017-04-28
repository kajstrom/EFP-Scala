package fi.kajstrom.efpscala.E42

import scala.io.Source
import java.io.File

import fi.kajstrom.efpscala.Util.FilePath

object E42 extends App{
  val sourceFile = FilePath.makeResourcePath("E42_in.txt")

  val rows = loadFileRows(sourceFile)
  val maxWidths = calculateColumnWidths(rows)

  printHeader(maxWidths)
  printRows(rows)

  private def printRows(rows: List[List[String]]) = {
    rows.foreach((row: List[String]) => {
      var printRow = ""

      for (i <- row.indices) {
        val column = row(i)
        val columnMaxWidth = maxWidths(i)

        printRow += column.padTo(columnMaxWidth, " ").mkString
      }

      println(printRow)
    })
  }

  private def calculateColumnWidths(rows: List[List[String]]): List[Int] = {
    val firstRow = rows.head
    var maxLengths: List[Int] = List()

    for (i <- firstRow.indices) {
      maxLengths :+=
        rows.foldLeft(0)((x: Int, y: List[String]) => {
          x max y(i).length
      })
    }

    maxLengths.map(_ + 1)
  }

  private def loadFileRows(file: String): List[List[String]] = {

    var rows: List[List[String]] = List()
    for (line <- Source.fromFile(file).getLines()) {
      rows :+= line.split(",").toList
    }

    rows
  }

  private def printHeader(maxWidths: List[Int]) = {
    print("Last".padTo(maxWidths(0), " ").mkString)
    print("First".padTo(maxWidths(1), " ").mkString)
    println("Salary".padTo(maxWidths(2), " ").mkString)

    println("".padTo(maxWidths.sum, "-").mkString)
  }
}
