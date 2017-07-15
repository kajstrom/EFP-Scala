package fi.kajstrom.efpscala.E56

import java.io.PrintWriter

import fi.kajstrom.efpscala.Util.FilePath

import scala.io.StdIn._

object E56 extends App{
  val inventoryService = new InventoryService

  start()

  def start(): Unit = {
    val action = promptAction
    runAction(action)
  }

  def promptAction: String = {
    println("Select action:")
    println("(A)dd item")
    println("(H)TML export")
    println("(C)SV export")
    println("(E)xit")

    readLine("").toUpperCase
  }

  def runAction(action: String) : Unit = {
    action match {
        case "A" => addItem
        case "H" => exportHTML
        case "C" => println("CSV")
        case "E" => System.exit(0)
    }

    start()
  }

  def addItem: Unit = {
    val name = readLine("Enter item name: ")
    val serialNumber = readLine("Enter item serial number: ")
    try {
      val value = readLine("Enter item value: ").toFloat

      inventoryService.add(InventoryItem(name, serialNumber, value))

    } catch {
      case nfe: NumberFormatException => {
        println("Invalid value... start over")
        addItem
      }
    }
  }

  def exportHTML: Unit = {
    val export = inventoryService.htmlExport
    val exportLocation = FilePath.makeResourcePath("E56_html.html")

    new PrintWriter(exportLocation) { write(export.html); close }

    println(s"HTML file written to: $exportLocation")
  }
}
