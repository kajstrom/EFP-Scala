package fi.kajstrom.efpscala.E24

import scala.io.StdIn._

/**
  * Created by Kaitsu on 3.4.2017.
  */
object E24 extends App{
  val ac = new AnagramChecker

  val first = promptFirstWord()
  val second = promptSecondWord()

  if (ac.isAnagram(first, second)) {
    println(s"$first and $second are anagrams.")
  } else {
    println(s"$first and $second are not anagrams.")
  }

  def promptFirstWord() : String = {
    println("Enter two strings and I'll tell you if they are anagrams: ")
    readLine("Enter the first string: ")
  }

  def promptSecondWord() : String = readLine("Enter the second string: ")
}
