package api

import api.Group.Liveview
import api.Group.LiveviewSize
import api.Group.LiveviewFrame
import api.StartLiveviewWithSize.LiveviewSizes
import org.junit.Test

/**
 * Tests for liveview [Api] classes.
 */
class LiveviewApiTest : ApiTest() {
  /**
   * [StartLiveview]
   */
  @Test
  fun startLiveview() = basicTest("startLiveview", Liveview)

  /**
   * [StopLiveview]
   */
  @Test
  fun stopLiveview() = basicTest("stopLiveview", Liveview)

  /**
   * [StartLiveviewWithSize]
   */
  @Test
  fun startLiveviewWithSize() = complexTest(
    method = "startLiveviewWithSize",
    group = LiveviewSize,
    input = InputType.Select,
    ioMap = mapOf(
      arrayOf(LiveviewSizes.XGA.title) to arrayOf("L"),
      arrayOf(LiveviewSizes.VGA.title) to arrayOf("M")
    )
  )

  /**
   * [GetLiveviewSize]
   */
  @Test
  fun getLiveviewSize() = basicTest("getLiveviewSize", LiveviewSize)

  /**
   * [GetSupportedLiveviewSize]
   */
  @Test
  fun getSupportedLiveviewSize() = basicTest("getSupportedLiveviewSize", LiveviewSize)

  /**
   * [GetAvailableLiveviewSize]
   */
  @Test
  fun getAvailableLiveviewSize() = basicTest("getAvailableLiveviewSize", LiveviewSize)

  /**
   * [SetLiveviewFrameInfo]
   */
  @Test
  fun setLiveviewFrameInfo() {
    val frame = "frameInfo"
    complexTest(
      method = "setLiveviewFrameInfo",
      group = LiveviewFrame,
      input = InputType.Select,
      ioMap = mapOf(
        arrayOf("On") to arrayOf(json(frame to true)),
        arrayOf("Off") to arrayOf(json(frame to false))
      )
    )
  }

  /**
   * [GetLiveviewFrameInfo]
   */
  @Test
  fun getLiveviewFrameInfo() = basicTest("getLiveviewFrameInfo", LiveviewFrame)
}