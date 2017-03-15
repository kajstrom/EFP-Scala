package fi.kajstrom.efpscala.E10

import scala.io.StdIn._

/**
  * Created by Kaitsu on 15.3.2017.
  */
object E10 extends App{

  val items = promptItems()

  outputResult(new Checkout(items))

  def promptItems() : List[Item] = {
    List[Item](
      promptItem(1),
      promptItem(2),
      promptItem(3)
    )
  }

  def promptItem(no: Int) : Item = {
    val price = readLine(s"Enter the price of item ${no}: ").toInt
    val quantity = readLine(s"Enter the quantity of item ${no}: ").toInt

    new Item(price, quantity)
  }

  def outputResult(checkout: Checkout) = print(checkout)
}
