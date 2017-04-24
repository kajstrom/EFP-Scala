package fi.kajstrom.efpscala.E44

import java.io.File
import play.api.libs.json._
import play.api.libs.functional.syntax._
import scala.io.Source

class ProductGateway {
  private val projectRoot = new File(".").getCanonicalPath
  private val ds = File.separator
  private val resources = projectRoot + ds + "resources"

  private def products: List[Product] = {
    val productJson = Source.fromFile(resources + s"${ds}E43_products.json").mkString
    implicit val productReads: Reads[Product] =(
      (__ \ "name").read[String] and
      (__ \ "price").read[Double] and
      (__ \ "quantity").read[Int]
    ) (Product)

    val json = Json.parse(productJson)
    val productsListing = (json \ "products")
    val products = productsListing.validate[List[Product]]

    val productsList = products match {
      case s: JsSuccess[List[Product]] => s.get
    }

    productsList
  }

  def findByName(name: String) : Option[Product] = {
    products.find(_.name.toLowerCase == name.toLowerCase)
  }
}

case class Product(name: String, price: Double, quantity: Int)
