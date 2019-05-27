package api

import api.ActZoom.ZoomDirections
import api.Group.Zoom
import api.Group.ZoomSetting
import api.SetZoomSetting.ZoomParameter
import org.junit.Test

/**
 * Tests for zoom [Api] classes.
 */
class ZoomApiTest : ApiTest() {
  /**
   * [ActZoom]
   */
  @Test
  fun actZoom() = complexTest(
    method = "actZoom",
    group = Zoom,
    input = InputType.Select,
    ioMap = mapOf(
      arrayOf(ZoomDirections.StartZoomIn.title) to ZoomDirections.StartZoomIn.param,
      arrayOf(ZoomDirections.StopZoomIn.title) to ZoomDirections.StopZoomIn.param,
      arrayOf(ZoomDirections.StartZoomOut.title) to ZoomDirections.StartZoomOut.param,
      arrayOf(ZoomDirections.StopZoomOut.title) to ZoomDirections.StopZoomOut.param,
      arrayOf(ZoomDirections.ShortZoomIn.title) to ZoomDirections.ShortZoomIn.param,
      arrayOf(ZoomDirections.ShortZoomOut.title) to ZoomDirections.ShortZoomOut.param
    )
  )

  /**
   * [SetZoomSetting]
   */
  @Test
  fun setZoomSetting() {
    val zoom = "zoom"
    complexTest(
      method = "setZoomSetting",
      group = ZoomSetting,
      input = InputType.Select,
      ioMap = mapOf(
        arrayOf(ZoomParameter.OpticalZoom.title) to arrayOf(
          json(zoom to ZoomParameter.OpticalZoom.param)
        ),
        arrayOf(ZoomParameter.SmartZoom.title) to arrayOf(
          json(zoom to ZoomParameter.SmartZoom.param)
        ),
        arrayOf(ZoomParameter.ClearImage.title) to arrayOf(
          json(zoom to ZoomParameter.ClearImage.param)
        ),
        arrayOf(ZoomParameter.DigitalZoomOn.title) to arrayOf(
          json(zoom to ZoomParameter.DigitalZoomOn.param)
        ),
        arrayOf(ZoomParameter.DigitalZoomOff.title) to arrayOf(
          json(zoom to ZoomParameter.DigitalZoomOff.param)
        )
      )
    )
  }

  /**
   * [GetZoomSetting]
   */
  @Test
  fun getZoomSetting() = basicTest("getZoomSetting", ZoomSetting)

  /**
   * [GetSupportedZoomSetting]
   */
  @Test
  fun getSupportedZoomSetting() = basicTest("getSupportedZoomSetting", ZoomSetting)

  /**
   * [GetAvailableZoomSetting]
   */
  @Test
  fun getAvailableZoomSetting() = basicTest("getAvailableZoomSetting", ZoomSetting)
}