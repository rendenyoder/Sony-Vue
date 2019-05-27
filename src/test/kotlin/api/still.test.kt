package api

import api.Group.IntervalStillRecording
import api.Group.StillCapture
import org.junit.Test

/**
 * Tests for still [Api] classes.
 */
class StillApiTest : ApiTest() {
  /**
   * [ActTakePicture]
   */
  @Test
  fun actTakePicture() = basicTest("actTakePicture", StillCapture)

  /**
   * [AwaitTakePicture]
   */
  @Test
  fun awaitTakePicture() = basicTest("awaitTakePicture", StillCapture)

  /**
   * [StartBulbShooting]
   */
  @Test
  fun startBulbShooting() = basicTest("startBulbShooting", StillCapture)

  /**
   * [StopBulbShooting]
   */
  @Test
  fun stopBulbShooting() = basicTest("stopBulbShooting", StillCapture)

  /**
   * [StartContShooting]
   */
  @Test
  fun startContShooting() = basicTest("startContShooting", StillCapture)

  /**
   * [StopContShooting]
   */
  @Test
  fun stopContShooting() = basicTest("stopContShooting", StillCapture)

  /**
   * [StartIntervalStillRec]
   */
  @Test
  fun startIntervalStillRec() = basicTest("startIntervalStillRec", IntervalStillRecording)

  /**
   * [StopIntervalStillRec]
   */
  @Test
  fun stopIntervalStillRec() = basicTest("stopIntervalStillRec", IntervalStillRecording)
}