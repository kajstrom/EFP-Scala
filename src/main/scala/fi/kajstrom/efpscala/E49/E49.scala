package fi.kajstrom.efpscala.E49

object E49 extends App {
  val is = new ImageService
  //is.findWithTag("nature")

  val mw = new MainWindow(is)
  mw.visible = true
}
