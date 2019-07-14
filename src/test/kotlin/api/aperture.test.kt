package api

import api.Group.FNumber
import org.junit.Test

/**
 * Tests for aperture related [Api] classes.
 */
class ApertureApiTest : ApiTest() {
  /**
   * [SetFNumber]
   * 
   * This test is sort of a hack as supported F-numbers vary for each individual lens.
   */
  @Test
  fun setFNumber() = complexTest(
    method = "setFNumber",
    group = FNumber,
    input = InputType.Numerical,
    ioMap = mapOf(
      arrayOf(2.8) to arrayOf(2.8)
    )
  )

  /**
   * [GetFNumber]
   */
  @Test
  fun getFNumber() {
    basicTest("getFNumber", FNumber)
  }

  /**
   * [GetSupportedFNumber]
   */
  @Test
  fun getSupportedFNumber() {
    basicTest("getSupportedFNumber", FNumber)
  }

  /**
   * [GetAvailableFNumber]
   */
  @Test
  fun getAvailableFNumber() {
    basicTest("getAvailableFNumber", FNumber)
  }
}
