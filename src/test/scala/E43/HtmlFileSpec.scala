package E43

import java.io.File
import java.nio.file.{Files, Paths}

import fi.kajstrom.efpscala.E43.HtmlFile
import org.scalatest.{BeforeAndAfterEach, FlatSpec, Matchers}

import scala.io.Source

class HtmlFileSpec extends FlatSpec with Matchers with BeforeAndAfterEach{
  val projectRoot = new File(".").getCanonicalPath
  val ds = File.separator
  val resourcesPath = projectRoot + ds + "resources"
  val testFile = "test.html"

  it should "write a file with name in title" in {
    val hf = new HtmlFile("test", "tester", ds)
    hf.writeTo(resourcesPath)

    val fileSource = Source.fromFile(resourcesPath + ds + testFile)
    fileSource.mkString should include ("<title>test</title>")
    fileSource.close()
  }

  it should "write a file with author name in author meta tag" in {
    val hf = new HtmlFile("test", "tester", ds)
    hf.writeTo(resourcesPath)

    val fileSource = Source.fromFile(resourcesPath + ds + testFile)
    fileSource.mkString should include ("<meta author='tester'>")
    fileSource.close()
  }

  override protected def afterEach(): Unit = {
    val dir = Paths.get(resourcesPath + ds + testFile)
    Files.delete(dir)
  }
}
