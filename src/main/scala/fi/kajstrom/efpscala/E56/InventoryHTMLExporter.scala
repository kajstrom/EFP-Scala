package fi.kajstrom.efpscala.E56

class InventoryHTMLExporter(inventory: List[InventoryItem]) {
  private val document = """
    <!doctype html>
    <html lang="en">
      <head>
        <meta charset="utf-8">
        <title>Inventory export</title>
      </head>
      <body>
        <h1>Inventory</h1>
        <table>
        <thead>
          <tr>
            <th>Name</th>
            <th>Serialnumber</th>
            <th>Value</th>
          </tr>
        </thead>
        <tbody>
        %placeholder%
        </tbody>
        </table>
      </body>
    </html>"""

  def generate(): InventoryHTMLExport = {
    var tableContents = inventory.map((item: InventoryItem) => {
      val row = s"""<tr>
        <td>${item.name}</td>
        <td>${item.serialNumber}</td>
        <td>${item.value}</td>
      """
      row
    }).mkString

    InventoryHTMLExport(document.replace("%placeholder%", tableContents))
  }
}
