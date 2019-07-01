package api

import api.Group.FocusMode
import api.Group.TouchAutoFocusPosition
import api.Group.TrackingFocus
import api.SetFocusMode.FocusModes
import org.junit.Test

/**
 * Tests for focus [Api] classes.
 */
class FocusApiTest : ApiTest() {
  /**
   * [SetTouchAFPosition]
   */
  @Test
  fun setTouchAFPosition() = complexTest(
    method = "setTouchAFPosition",
    group = TouchAutoFocusPosition,
    input = InputType.Numerical,
    ioMap = mapOf(
      arrayOf(10, 18) to arrayOf(10, 18),
      arrayOf(30.5, 50.1) to arrayOf(30.5, 50.1),
      arrayOf(40, 100) to arrayOf(40, 100)
    )
  )

  /**
   * [GetTouchAFPosition]
   */
  @Test
  fun getTouchAFPosition() = basicTest("getTouchAFPosition", TouchAutoFocusPosition)

  /**
   * [CancelTouchAFPosition]
   */
  @Test
  fun cancelTouchAFPosition() = basicTest("cancelTouchAFPosition", TouchAutoFocusPosition)

  /**
   * [ActTrackingFocus]
   */
  @Test
  fun actTrackingFocus() {
    val x = "xPosition"
    val y = "yPosition"
    complexTest(
      method = "actTrackingFocus",
      group = TrackingFocus,
      input = InputType.Numerical,
      ioMap = mapOf(
        arrayOf(10, 31) to arrayOf(json(x to 10, y to 31)),
        arrayOf(12.25, 4.01) to arrayOf(json(x to 12.25, y to 4.01)),
        arrayOf(10, 100) to arrayOf(json(x to 10, y to 100))
      )
    )
  }

  /**
   * [SetTrackingFocus]
   */
  @Test
  fun setTrackingFocus() {
    val focus = "trackingFocus"
    complexTest(
      method = "setTrackingFocus",
      group = TrackingFocus,
      input = InputType.Select,
      ioMap = mapOf(
        arrayOf("On") to arrayOf(json(focus to "On")),
        arrayOf("Off") to arrayOf(json(focus to "Off"))
      )
    )
  }

  /**
   * [CancelTrackingFocus]
   */
  @Test
  fun cancelTrackingFocus() {
    basicTest("cancelTrackingFocus", TrackingFocus)
  }

  /**
   * [GetTrackingFocus]
   */
  @Test
  fun getTrackingFocus() {
    basicTest("getTrackingFocus", TrackingFocus)
  }

  /**
   * [GetSupportedTrackingFocus]
   */
  @Test
  fun getSupportedTrackingFocus() {
    basicTest("getSupportedTrackingFocus", TrackingFocus)
  }

  /**
   * [GetAvailableTrackingFocus]
   */
  @Test
  fun getAvailableTrackingFocus() {
    basicTest("getAvailableTrackingFocus", TrackingFocus)
  }

  /**
   * [SetFocusMode]
   */
  @Test
  fun setFocusMode() {
    complexTest(
      method = "setFocusMode",
      group = FocusMode,
      input = InputType.Select,
      ioMap = mapOf(
        arrayOf(FocusModes.AFS.title) to arrayOf(FocusModes.AFS.param),
        arrayOf(FocusModes.AFC.title) to arrayOf(FocusModes.AFC.param),
        arrayOf(FocusModes.DMF.title) to arrayOf(FocusModes.DMF.param),
        arrayOf(FocusModes.MF.title) to arrayOf(FocusModes.MF.param)
      )
    )
  }

  /**
   * [GetFocusMode]
   */
  @Test
  fun getFocusMode() {
    basicTest("getFocusMode", FocusMode)
  }

  /**
   * [GetSupportedFocusMode]
   */
  @Test
  fun getSupportedFocusMode() {
    basicTest("getSupportedFocusMode", FocusMode)
  }

  /**
   * [GetAvailableFocusMode]
   */
  @Test
  fun getAvailableFocusMode() {
    basicTest("getAvailableFocusMode", FocusMode)
  }
}