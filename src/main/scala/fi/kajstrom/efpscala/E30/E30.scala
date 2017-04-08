package fi.kajstrom.efpscala.E30

object E30 extends App{
  var multiplier1 = 0
  var multiplier2 = 0

  //Exercise constraint was to use nested loops.
  for (multiplier1 <- 0 to 12) {
    for (multiplier2 <- 0 to 12) {
      println(s"$multiplier1 x $multiplier2 = " + (multiplier1 * multiplier2).toString)
    }
  }
}
