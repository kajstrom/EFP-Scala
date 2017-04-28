package fi.kajstrom.efpscala.E41

import scala.io.Source
import java.io._

import fi.kajstrom.efpscala.Util.FilePath

object E41 extends App{
  val source = FilePath.makeResourcePath("E41_in.txt")
  val out = FilePath.makeResourcePath("E41_out.txt")
  var names: List[String] = List()


  for (line <- Source.fromFile(source).getLines()) {
    names :+= line.mkString
  }

  val pw = new PrintWriter(new File(out))
  val nl = sys.props("line.separator")

  pw.write(s"Total of ${names.length} names$nl")
  pw.write(s"----------------$nl")

  names = names.sorted

  names.foreach((name: String) => pw.write(name + nl))

  pw.close()
}
