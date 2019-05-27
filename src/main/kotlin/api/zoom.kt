/**
 * Apis that handle camera zoom functionality and camera zoom settings.
 *
 * @author  Renden Yoder
 * @version 1.0
 * @since   2018-12-20
 */
package api

import org.json.JSONObject

/**
 * This API provides a function to zoom.
 */
class ActZoom : Api(
  method = "actZoom",
  group = Group.Zoom,
  description = "Zoom",
  options = InputType.Select to arrayOf(
    ZoomDirections.StartZoomIn.title,
    ZoomDirections.StopZoomIn.title,
    ZoomDirections.StartZoomOut.title,
    ZoomDirections.StopZoomOut.title,
    ZoomDirections.ShortZoomIn.title,
    ZoomDirections.ShortZoomOut.title
  )
) {
  /**
   * Exception to be thrown when a given [ZoomDirections] string is invalid.
   */
  class InvalidZoomParam(message: String) : Exception(message)

  /**
   * Outlines all possible zoom operations.
   */
  enum class ZoomDirections(val title: String, val param: Array<Any>) {
    StartZoomIn("Start Zoom In", arrayOf("in", "start")),
    StopZoomIn("Stop Zoom In", arrayOf("in", "stop")),
    StartZoomOut("Start Zoom Out", arrayOf("out", "start")),
    StopZoomOut("Stop Zoom Out", arrayOf("out", "stop")),
    ShortZoomIn("Short Zoom In", arrayOf("in", "1shot")),
    ShortZoomOut("Short Zoom Out", arrayOf("out", "1shot"));

    companion object {
      fun fromString(title: String): ZoomDirections {
        return ZoomDirections.values().find { it.title == title }
          ?: throw InvalidZoomParam("No zoom command for '$title'!")
      }
    }
  }

  override fun parse(params: Array<Any>): Array<Any> {
    val zoom = params.first()
    return if (zoom is String) {
      ZoomDirections.fromString(zoom).param
    } else {
      throw InvalidZoomParam("Only string parameters are permitted!")
    }
  }
}

/**
 * This API provides a function to set a value for the zoom settings.
 */
class SetZoomSetting : Api(
  method = "setZoomSetting",
  group = Group.ZoomSetting,
  description = "Set Zoom Settings",
  options = InputType.Select to arrayOf(
    ZoomParameter.OpticalZoom.title,
    ZoomParameter.SmartZoom.title,
    ZoomParameter.ClearImage.title,
    ZoomParameter.DigitalZoomOn.title,
    ZoomParameter.DigitalZoomOff.title
  )
) {
  /**
   * Exception to be thrown when a given [ZoomParameter] string is invalid.
   */
  class InvalidZoomParam(message: String) : Exception(message)

  /**
   * Outlines all possible zoom settings parameters.
   */
  enum class ZoomParameter(val title: String, val param: String) {
    OpticalZoom("Optical Zoom", "Optical Zoom Only"),
    SmartZoom("Smart Zoom", "Smart Zoom Only"),
    ClearImage("Clear Image Zoom", "On:Clear Image Zoom"),
    DigitalZoomOn("Digital Zoom On", "On:Digital Zoom"),
    DigitalZoomOff("Digital Zoom Off", "Off:Digital Zoom");

    companion object {
      fun fromString(title: String): ZoomParameter {
        return ZoomParameter.values().find { it.title == title }
          ?: throw InvalidZoomParam("No zoom command for '$title'!")
      }
    }
  }

  override fun parse(params: Array<Any>): Array<Any> {
    val zoomParam = params.first()
    return if (zoomParam is String) {
      val zoomObject = JSONObject().put("zoom", ZoomParameter.fromString(zoomParam).param)
      arrayOf(zoomObject)
    } else {
      throw InvalidZoomParam("Only string parameters are permitted!")
    }
  }
}

/**
 * This API provides a function to get current zoom setting.
 */
class GetZoomSetting : Api (
  method = "getZoomSetting",
  group = Group.ZoomSetting,
  description = "Get Zoom Settings"
)

/**
 * This API provides a function to get the supported zoom settings. The client should use
 * "getAvailableZoomSetting" to get the available parameters at the moment.
 */
class GetSupportedZoomSetting : Api (
  method = "getSupportedZoomSetting",
  group = Group.ZoomSetting,
  description = "Get Supported Zoom Settings"
)

/**
 * This API provides a function to get current zoom setting and the available zoom
 * settings at the moment. The available parameters can be changed by user operations and
 * calling APIs.
 */
class GetAvailableZoomSetting : Api (
  method = "getAvailableZoomSetting",
  group = Group.ZoomSetting,
  description = "Get Available Zoom Settings"
)