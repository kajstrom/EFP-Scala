package fi.kajstrom.efpscala.E56

import java.io.PrintWriter
import java.nio.file.{Files, Paths}

import play.api.libs.json._
import play.api.libs.functional.syntax._
import fi.kajstrom.efpscala.Util.FilePath

import scala.io.Source

class InventoryService {
  private val storagePath = Paths.get(FilePath.makeResourcePath("E56_inventory.json"))
  private var inventory = loadInventory()
  println(inventory)

  def add(item: InventoryItem): Unit = {
    inventory = inventory :+ item
    persistInventory()
  }

  private def persistInventory(): Unit = {
    val json = Json.toJson(inventory)
    new PrintWriter(storagePath.toString) { write(Json.stringify(json)); close }
  }

  private def loadInventory(): List[InventoryItem] = {
    if (Files.exists(storagePath)) {
      val itemJson = Source.fromFile(storagePath.toString).mkString
      val json = Json.parse(itemJson)

      json.validate[List[InventoryItem]] match {
        case s: JsSuccess[List[InventoryItem]] => s.get
        case e: JsError => List[InventoryItem]()
      }
    } else {
      List[InventoryItem]()
    }
  }
}

object InventoryItem {
  implicit val inventoryItemWrites: Writes[InventoryItem] = (
      (JsPath \ "name").write[String] and
      (JsPath \ "serialNumber").write[String] and
      (JsPath \ "value").write[Float]
    )(unlift(InventoryItem.unapply))

  implicit val inventoryItemReads: Reads[InventoryItem] = (
      (JsPath \ "name").read[String] and
      (JsPath \ "serialNumber").read[String] and
      (JsPath \ "value").read[Float]
  )(InventoryItem.apply _)
}

case class InventoryItem(name: String, serialNumber: String, value: Float) {}