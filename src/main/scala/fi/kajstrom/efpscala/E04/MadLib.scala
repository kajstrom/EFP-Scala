package fi.kajstrom.efpscala.E04

/**
  * Created by Kaitsu on 22.1.2017.
  */
class MadLib {
  def sentence(noun: String, verb: String, adjective: String, adverb: String): String = {
    s"Do you ${verb} your ${adjective} ${noun} ${adverb}? That's hilarious!"
  }
}
