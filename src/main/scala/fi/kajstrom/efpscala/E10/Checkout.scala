package fi.kajstrom.efpscala.E10

/**
  * Created by Kaitsu on 6.3.2017.
  */
class Checkout(items: List[Item]) {
  def subtotal(): Double = items.map(_.total()).sum
  def tax(): Double = items.map(_.tax()).sum
  def total(): Double = subtotal() + tax()

  override def toString(): String = {
    var str = f"Subtotal: $$${subtotal()}%.2f\n"
    str += f"Tax: $$${tax()}%.2f\n"
    str += f"Total: $$${total()}%.2f"

    str
  }
}

case class Item(price: Int, quantity: Int) {
  val taxRate = 0.055

  def total(): Double = price.toDouble * quantity
  def tax(): Double = total().toDouble * taxRate
}