/**
 * Apis that handle camera liveview functionality. This includes starting liveview
 * streaming and setting liveview quality.
 *
 * @author  Renden Yoder
 * @version 1.0
 * @since   2018-12-20
 */
package api

import org.json.JSONObject

/**
 * This API provides a function to start liveview.
 */
class StartLiveview : Api(
  method = "startLiveview",
  group = Group.Liveview,
  description = "Start Liveview"
)

/**
 * This API provides a function to stop liveview.
 */
class StopLiveview : Api(
  method = "stopLiveview",
  group = Group.Liveview,
  description = "Stop Liveview"
)

/**
 * This API provides a function to start liveview with specific liveview size.
 */
class StartLiveviewWithSize : Api(
  method = "startLiveviewWithSize",
  group = Group.LiveviewSize,
  description = "Start Liveview with Size",
  options = InputType.Select to arrayOf(LiveviewSizes.XGA.title, LiveviewSizes.VGA.title)
) {
  /**
   * Exception to be thrown when a given [LiveviewSizes] string is invalid.
   */
  class InvalidLiveviewSize(message: String) : Exception(message)

  /**
   * Outlines all possible liveview sizes.
   */
  enum class LiveviewSizes(val title: String, val param: String) {
    XGA("XGA Size Scale", "L"),
    VGA("VGA Size Scale", "M");

    companion object {
      fun fromString(title: String): LiveviewSizes {
        val size = LiveviewSizes.values().find { it.title == title }
        return size
          ?: throw InvalidLiveviewSize("No liveview size for '$title'!")
      }
    }
  }
  
  override fun parse(params: Array<Any>): Array<Any> {
    val size = params.first()
    return if (size is String) {
      arrayOf(LiveviewSizes.fromString(size).param)
    } else {
      throw InvalidLiveviewSize("Only string parameters are permitted!")
    }
  }
}

/**
 * This API provides a function to get current liveview size.
 */
class GetLiveviewSize : Api(
  method = "getLiveviewSize",
  group = Group.LiveviewSize,
  description = "Get Current Liveview Size"
)

/**
 * This API provides a function to get the supported liveview sizes. The client should use
 * "getAvailableLiveviewSize" to get the available parameters at the moment.
 */
class GetSupportedLiveviewSize : Api(
  method = "getSupportedLiveviewSize",
  group = Group.LiveviewSize,
  description = "Get Supported Liveview Size"
)

/**
 * This API provides a function to get current liveview size and the available liveview
 * sizes at the moment. The available parameters can be changed by user operations and
 * calling APIs.
 */
class GetAvailableLiveviewSize : Api(
  method = "getAvailableLiveviewSize",
  group = Group.LiveviewSize,
  description = "Get Available Liveview Size"
)

/**
 * This API provides a function to switch the liveview frame information transferring. The
 * liveview frame information includes focus frames, face detection frames and tracking
 * frames on the liveview.
 */
class SetLiveviewFrameInfo : Api(
  method = "setLiveviewFrameInfo",
  group = Group.LiveviewFrame,
  description = "Set Liveview Frame Info",
  options = InputType.Select to arrayOf("On", "Off")
) {
  /**
   * Exception to be thrown when a given [options] string is invalid.
   */
  class InvalidLiveviewFrameInfo(message: String) : Exception(message)

  override fun parse(params: Array<Any>): Array<Any> {
    val state = params.first()
    return if (state is String) {
      val bool = when (state.toLowerCase()) {
        "on" -> true
        "off" -> false
        else -> {
          throw InvalidLiveviewFrameInfo("No liveview frame state for '$state'!")
        }
      }
      val frameInfo = JSONObject().put("frameInfo", bool)
      arrayOf(frameInfo)
    } else {
      throw InvalidLiveviewFrameInfo("Only string parameters are permitted!")
    }
  }
}

/**
 * This API provides a function to get current setting of the liveview frame information
 * transferring.
 */
class GetLiveviewFrameInfo : Api(
  method = "getLiveviewFrameInfo",
  group = Group.LiveviewFrame,
  description = "Get Liveview From Info"
)
