package api

import api.Group.CameraSetup
import org.junit.Test

/**
 * Tests for setup [Api] classes.
 */
class SetupApiTest : ApiTest() {
  /**
   * [StartRecMode]
   */
  @Test
  fun startRecMode() = basicTest("startRecMode", CameraSetup)

  /**
   * [StopRecMode]
   */
  @Test
  fun stopRecMode() = basicTest("stopRecMode", CameraSetup)
}