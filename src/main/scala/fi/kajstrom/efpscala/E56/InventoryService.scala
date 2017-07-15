package fi.kajstrom.efpscala.E56

import java.io.PrintWriter
import java.nio.file.{Files, Paths}

import play.api.libs.json._
import play.api.libs.functional.syntax._
import fi.kajstrom.efpscala.Util.FilePath

class InventoryService {
  private var inventory = List[InventoryItem]()
  private val storagePath = Paths.get(FilePath.makeResourcePath("E56_inventory.json"))

  def add(item: InventoryItem): Unit = {
    inventory = inventory :+ item
    persistInventory()
  }

  private def persistInventory(): Unit = {
    val json = Json.toJson(inventory)
    new PrintWriter(storagePath.toString) { write(Json.stringify(json)); close }
  }
}

object InventoryItem {
  implicit val inventoryItemWrites: Writes[InventoryItem] = (
      (JsPath \ "name").write[String] and
      (JsPath \ "serialNumber").write[String] and
      (JsPath \ "value").write[Float]
    )(unlift(InventoryItem.unapply))
}

case class InventoryItem(name: String, serialNumber: String, value: Float) {}