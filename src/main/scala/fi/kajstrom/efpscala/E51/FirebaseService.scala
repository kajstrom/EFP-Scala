package fi.kajstrom.efpscala.E51

import play.api.libs.ws.ahc.AhcWSClient

import scala.concurrent.Await
import scala.concurrent.duration.Duration

/**
  * Created by Kaitsu on 9.5.2017.
  */
class FirebaseService(client: AhcWSClient) {
  def addNote(notebook: String, note: String): Boolean = {
    val responseFuture = client
      .url(s"https://exercises-for-programmers.firebaseio.com/notebooks/$notebook.json")
      .post("{\"content\": \"" + note + "\"}")

    val result = Await.result(responseFuture, Duration.Inf)

    client.close()

    result.status == 200
  }
}
