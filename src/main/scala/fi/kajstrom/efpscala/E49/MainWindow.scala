package fi.kajstrom.efpscala.E49

import java.net.URL
import javax.swing.ImageIcon

import scala.swing._

class MainWindow(imageService: ImageService) extends MainFrame{
  title = "Photo Search"
  preferredSize = new Dimension(640, 480)
  contents = new BoxPanel(Orientation.Horizontal) {
    val text = new TextField()
    text.maximumSize = new Dimension(150, 30)
    contents += text
    contents += Button("Search") {
      val images = imageService.findWithTag(text.text)
      println(images)
      showImages(images)
    }
  }

  def showImages(images: List[Image]): Unit = {
    import javax.imageio.ImageIO
    import java.awt.image.BufferedImage


    contents = new BoxPanel(Orientation.Vertical) {
      images.take(1).foreach((image: Image) => {
        val url = new URL(images.head.url)
        val img: BufferedImage = ImageIO.read(url)

        val label = new Label {
          icon = new ImageIcon(img)
        }

        contents += label
      })
    }
  }
}
