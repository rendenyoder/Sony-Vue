package api

import api.Group.SelfTimer
import api.SetSelfTimer.Timer
import org.junit.Test

/**
 * Tests for timer [Api] classes.
 */
class TimerApiTest : ApiTest() {
  /**
   * [SetSelfTimer]
   */
  @Test
  fun setSelfTimer() = complexTest(
    method = "setSelfTimer",
    group = SelfTimer,
    input = InputType.Select,
    ioMap = mapOf(
      arrayOf(Timer.Zero.title) to arrayOf(0),
      arrayOf(Timer.Two.title) to arrayOf(2),
      arrayOf(Timer.Ten.title) to arrayOf(10)
    )
  )

  /**
   * [GetSelfTimer]
   */
  @Test
  fun getSelfTimer() = basicTest("getSelfTimer", SelfTimer)

  /**
   * [GetSupportedSelfTimer]
   */
  @Test
  fun getSupportedSelfTimer() = basicTest("getSupportedSelfTimer", SelfTimer)

  /**
   * [GetAvailableSelfTimer]
   */
  @Test
  fun getAvailableSelfTimer() = basicTest("getAvailableSelfTimer", SelfTimer)
}