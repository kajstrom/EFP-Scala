package fi.kajstrom.efpscala.E24

import scala.collection.mutable

/**
  * Simplistic implementation that only works with words and now whole sentences. Spaces, commas etc. are not
  * taken into consideration.
  */

class AnagramChecker {
  def isAnagram(first: String, second: String) : Boolean = {
    if (first.length == second.length){
      val firstChars = charOccurences(first)
      val secondChars = charOccurences(second)

      areEqual(firstChars, secondChars)
    } else {
      false
    }
  }

  private def areEqual(first: mutable.Map[Char, Int], second: mutable.Map[Char, Int]) : Boolean = {
    var equal = true

    first.foreach((c: (Char,Int)) => {
      if (second.contains(c._1)) {
        if (second(c._1) != c._2) {
          equal = false
        }
      } else {
        equal = false
      }
    })

    equal
  }

  private def charOccurences(word: String) : mutable.Map[Char, Int] = {
    val occurences: mutable.Map[Char, Int] = mutable.Map()


    word.toList.foreach((c: Char) => {
      if (occurences.contains(c)) {
        occurences(c) = occurences(c) + 1
      } else {
        occurences(c) = 1
      }
    })

    occurences
  }
}
