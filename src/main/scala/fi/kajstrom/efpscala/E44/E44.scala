package fi.kajstrom.efpscala.E44

import scala.io.StdIn._

object E44 extends App{
  val productGateway = new ProductGateway

  searchProduct()

  def searchProduct(): Unit = {
    val searchName = readLine("What is the product name? ")
    val resultProduct = productGateway.findByName(searchName)

    resultProduct match {
      case some: Some[Product] => {
        val product = some.get
        println(s"Name ${product.name}")
        println(s"Price: ${product.price}")
        println(s"Quantity on hand:  ${product.quantity}")
      }
      case None => {
        println(s"No product with name $searchName. Try again.")
        searchProduct()
      }
    }
  }
}
