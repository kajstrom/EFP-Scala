package fi.kajstrom.efpscala.E49

import scala.xml._

class ImageService {
  def findWithTag(tags: String): List[Image] = {
    val xml = XML.loadString(retrieveImageXML(tags))
    val images = (xml \ "entry" \ "link")
      .filter((image: Node) => {
        image.attribute("type").get.toString == "image/jpeg"
      })
      .map((image: Node) => {
        Image(image.attribute("href").get.toString())
    })
    .toList

    images
  }

  private def retrieveImageXML(query: String): String = {
    import java.net.{URL, HttpURLConnection}
    val connection = new URL(s"https://api.flickr.com/services/feeds/photos_public.gne?tags=$query").openConnection.asInstanceOf[HttpURLConnection]

    connection.setConnectTimeout(3000)
    connection.setReadTimeout(3000)
    connection.setRequestMethod("GET")

    val inputStream = connection.getInputStream
    val content = scala.io.Source.fromInputStream(inputStream).mkString

    if (inputStream != null) inputStream.close()

    content
  }
}

case class Image(url: String)