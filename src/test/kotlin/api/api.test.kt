package api

import org.json.JSONObject
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Assert.assertArrayEquals


/**
 * Contains general structure for how [Api] classes will be tested.
 */
open class ApiTest {
  /**
   * Factory class for [Api].
   */
  val factory = ApiFactory()

  /**
   * Test for [Api] classes that have no options.
   */
  fun basicTest(method: String, group: Group) {
    try {
      // Ensure api can be created from method
      val api = factory.create(method)
      assertEquals(group, api.group)
      // Ensure param input type is correct
      assertEquals(InputType.None, api.options.first)
      // Ensure params are empty
      assertEquals(0, api.options.second.size)
    } catch (e: Exception) {
      fail("Could not create api from $method")
    }
  }

  /**
   * Test for [Api] classes that have options.
   */
  fun complexTest(
    method: String,
    group: Group,
    input: InputType,
    ioMap: Map<Array<*>, Array<*>>
  ) {
    try {
      // Ensure api can be created from method
      val api = factory.create(method)
      assertEquals(group, api.group)
      // Ensure param input type is correct
      assertEquals(input, api.options.first)
      // Ensure params are parsed correctly
      ioMap.forEach { request, response ->
        // Check if response is an array of json
        if (response.isArrayOf<JSONObject>()) {
          // Convert json reponses and parsed results to maps
          val responseMap = jsonMap(response)
          val resultMap = jsonMap(api.parse(request as Array<Any>))
          // Check that maps are equal
          assertEquals(responseMap, resultMap)
        } else {
          assertArrayEquals(response, api.parse(request as Array<Any>))
        }
      }
    } catch (e: Exception) {
      fail("Could not create api from $method")
    }
  }

  /**
   * Creates json from a list of pairs.
   */
  fun json(vararg pairs: Pair<Any, Any>): JSONObject {
    val map = mutableMapOf<Any, Any>().apply { 
      pairs.forEach { (k, v) -> put(k, v) }
    }
    return JSONObject(map)
  }

  /**
   * Creates a list of maps created from json objects.
   */
  private fun jsonMap(array: Array<*>): List<MutableMap<String, Any>> {
    return array.map {
      val json = it as JSONObject
      json.toMap()
    }
  }
}