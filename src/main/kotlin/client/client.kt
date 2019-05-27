package client

import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils
import org.json.JSONObject

/**
 * Interface for a client object. Aids in tests.
 */
interface Client {
  /**
   * This method makes the request to the Sony Camera's web server.
   */
  fun request(method: String, params: Array<Any>): JSONObject
}

/**
 * Client to be used in order to interact with the web server hosted by the Sony Camera.
 */
object SonyClient : Client {
  private var url = "http://192.168.122.1:8080/sony/camera" // TODO: Get from config file
  private var cli: HttpClient = HttpClients.createDefault()

  /**
   * This method makes the request to the Sony Camera's web server.
   * @param method Name of method being called.
   * @param params List of params being passed to Sony API endpoint.
   * @return Response of endpoint as [JSONObject].
   */
  override fun request(method: String, params: Array<Any>): JSONObject {
    val post = HttpPost(url).apply {
      setHeader("Content-type", "application/json")
      val data = JSONObject().apply {
        put("id", 1)
        put("version", "1.0")
        put("method", method)
        put("params", params)
      }
      entity = StringEntity(data.toString(0))
    }
    val rsp = EntityUtils.toString(cli.execute(post).entity)
    return JSONObject(rsp)
  }
}
