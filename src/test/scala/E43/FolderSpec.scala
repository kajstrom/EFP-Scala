package E43

import java.io.File
import java.nio.file
import java.nio.file.{Files, Paths, SimpleFileVisitor}

import fi.kajstrom.efpscala.E43.Folder
import org.scalatest.{BeforeAndAfter, BeforeAndAfterEach, FlatSpec, Matchers}

import scala.reflect.io.Path

/**
  * This is not strictly a unit test as it touches the file system.
  */
class FolderSpec extends FlatSpec with Matchers with BeforeAndAfterEach {
  val projectRoot = new File(".").getCanonicalPath
  val ds = File.separator
  val resourcesPath = projectRoot + ds + "resources"

  val testFolder = "testsite"

  it should "return true when target is successfully created" in {
    val folder = new Folder(testFolder, ds)

    folder.writeTo(resourcesPath) should be(true)
    Files.exists(Paths.get(resourcesPath + ds + testFolder))
  }

  it should "return false when target directory already exists" in {
    val folder = new Folder(testFolder, ds)

    folder.writeTo(resourcesPath)
    folder.writeTo(resourcesPath) should be(false)
  }

  override protected def afterEach(): Unit = {
    val dir = Paths.get(resourcesPath + ds + testFolder)
    Files.delete(dir)
  }
}
