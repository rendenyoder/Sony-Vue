package api

import api.Group.HalfPressShutter
import org.junit.Test

/**
 * Tests for shutter [Api] classes.
 */
class ShutterApiTest : ApiTest() {
  /**
   * [ActHalfPressShutter]
   */
  @Test
  fun actHalfPressShutter() = basicTest("actHalfPressShutter", HalfPressShutter)

  /**
   * [CancelHalfPressShutter]
   */
  @Test
  fun cancelHalfPressShutter() = basicTest("cancelHalfPressShutter", HalfPressShutter)
}