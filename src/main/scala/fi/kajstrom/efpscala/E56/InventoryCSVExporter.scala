package fi.kajstrom.efpscala.E56

import fi.kajstrom.efpscala.Util.FilePath

class InventoryCSVExporter(inventory: List[InventoryItem]) {
  def generate(): InventoryCSVExport = {
    var csv = "Name,Serial number,Value\r\n"

    csv += inventory.map((item: InventoryItem) => {
      s"${item.name},${item.serialNumber},${item.value}\r\n"
    }).mkString

    InventoryCSVExport(csv)
  }
}
