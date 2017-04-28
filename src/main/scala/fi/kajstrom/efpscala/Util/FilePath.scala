package fi.kajstrom.efpscala.Util

import java.io.File

object FilePath {
  def ds: String = File.separator
  def resourcesPath: String = {
    val projectRoot = new File(".").getCanonicalPath

    projectRoot + ds + "resources"
  }

  def makeResourcePath(parts: String*): String = resourcesPath + ds +  parts.mkString(ds)
}
