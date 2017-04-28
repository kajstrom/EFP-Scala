package E43

import java.io.File
import java.nio.file.{Files, Paths}

import fi.kajstrom.efpscala.E43.{HtmlFile, NullLogger}
import fi.kajstrom.efpscala.Util.FilePath
import org.scalatest.{BeforeAndAfterEach, FlatSpec, Matchers}

import scala.io.Source

class HtmlFileSpec extends FlatSpec with Matchers with BeforeAndAfterEach{
  val testFile = "test.html"

  it should "write a file with name in title" in {
    val hf = new HtmlFile(NullLogger, "test", "tester", FilePath.ds)
    hf.writeTo(FilePath.resourcesPath)

    val fileSource = Source.fromFile(FilePath.makeResourcePath(testFile))
    fileSource.mkString should include ("<title>test</title>")
    fileSource.close()
  }

  it should "write a file with author name in author meta tag" in {
    val hf = new HtmlFile(NullLogger, "test", "tester", FilePath.ds)
    hf.writeTo(FilePath.resourcesPath)

    val fileSource = Source.fromFile(FilePath.makeResourcePath(testFile))
    fileSource.mkString should include ("<meta author='tester'>")
    fileSource.close()
  }

  override protected def afterEach(): Unit = {
    val dir = Paths.get(FilePath.makeResourcePath(testFile))
    Files.delete(dir)
  }
}
