package fi.kajstrom.efpscala.E23

/**
  * Created by Kaitsu on 2.4.2017.
  */
object E23 extends App {
  val ts = new CarTroubleShooter(new CommandLineAdapter)

  ts.start()
}
