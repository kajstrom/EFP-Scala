package fi.kajstrom.efpscala.E04

import scala.io.StdIn._
/**
  * Created by Kaitsu on 22.1.2017.
  */
object E04 extends App{

  val noun = promptNoun()
  val verb = promptVerb()
  val adjective = promptAdjective()
  val adverb = promptAdverb()

  val madLib = new MadLib

  outputSentence(madLib.sentence(noun, verb, adjective, adverb))



  def promptNoun(): String = readLine("Enter a noun: ")
  def promptVerb(): String = readLine("Enter a verb: ")
  def promptAdjective(): String = readLine("Enter an adjective: ")
  def promptAdverb(): String = readLine("Enter an adverb: " )
  def outputSentence(sentence: String): Unit = println(sentence)
}
