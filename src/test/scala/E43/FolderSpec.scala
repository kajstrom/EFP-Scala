package E43

import java.io.File
import java.nio.file.{Files, Paths, SimpleFileVisitor}

import fi.kajstrom.efpscala.E43.{Folder, NullLogger}
import fi.kajstrom.efpscala.Util.FilePath
import org.scalatest.{BeforeAndAfterEach, FlatSpec, Matchers}

/**
  * This is not strictly a unit test as it touches the file system.
  */
class FolderSpec extends FlatSpec with Matchers with BeforeAndAfterEach {
  val testFolder = "testsite"

  it should "return true when target is successfully created" in {
    val folder = new Folder(NullLogger, testFolder, FilePath.ds)

    folder.writeTo(FilePath.resourcesPath) should be(true)
    Files.exists(Paths.get(FilePath.makeResourcePath(testFolder)))
  }

  it should "return false when target directory already exists" in {
    val folder = new Folder(NullLogger, testFolder, FilePath.ds)

    folder.writeTo(FilePath.resourcesPath)
    folder.writeTo(FilePath.resourcesPath) should be(false)
  }

  override protected def afterEach(): Unit = {
    val dir = Paths.get(FilePath.makeResourcePath(testFolder))
    Files.delete(dir)
  }
}
