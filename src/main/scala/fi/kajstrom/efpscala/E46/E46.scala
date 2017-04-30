package fi.kajstrom.efpscala.E46

import fi.kajstrom.efpscala.Util.FilePath

import scala.collection.mutable
import scala.io.{BufferedSource, Source}

object E46 extends App{
  val file = Source.fromFile(FilePath.makeResourcePath("E46_in.txt"))
  val words: List[String] = splitToWords(file)
  val wordCounts : mutable.Map[String, Int] = mutable.Map()

  words.foreach((word: String) => wordCounts(word) = wordCounts.getOrElse(word, 0) + 1)

  wordCounts.foreach((word: (String, Int)) => {
    print(word._1 + ": ")
    println("".padTo(word._2, "*").mkString)
  })

  private def splitToWords(file: BufferedSource): List[String] = {
    var words: List[String] = List()
    for (line <- file.getLines()) {
      line.mkString.split(" ").foreach(words :+= _)
    }

    words
  }
}