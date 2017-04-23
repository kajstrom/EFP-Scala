package fi.kajstrom.efpscala.E43

import java.io.File

class Folder(name: String, ds: String) extends SiteComponent{
  private var contents: List[SiteComponent] = List()

  def addComponent(component: SiteComponent) : Unit = contents :+= component

  override def writeTo(folder: String): Boolean = {
    val folderPath = folder + ds + name

    val dir = new File(folder + ds + name)
    val success = dir.mkdir()

    if (success) {
      println(s"Created $folderPath")
      contents.foldLeft(true)((success: Boolean, component: SiteComponent) => {
        if (success) {
          component.writeTo(folderPath)
        } else {
          false
        }
      })
    } else {
      false
    }
  }
}
