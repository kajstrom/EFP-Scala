package fi.kajstrom.efpscala.E41

import scala.io.Source
import java.io._

object E41 extends App{
  val projectRoot = new File(".").getCanonicalPath
  val ds = File.separator
  val source = s"${ds}resources${ds}E41_in.txt"
  val out = s"${ds}resources${ds}E41_out.txt"
  var names: List[String] = List()


  for (line <- Source.fromFile(projectRoot + source).getLines()) {
    names :+= line.mkString
  }

  val pw = new PrintWriter(new File(projectRoot + out))
  val nl = sys.props("line.separator")

  pw.write(s"Total of ${names.length} names$nl")
  pw.write(s"----------------$nl")

  names = names.sorted

  names.foreach((name: String) => pw.write(name + nl))

  pw.close()
}
