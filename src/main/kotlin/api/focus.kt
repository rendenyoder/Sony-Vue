/**
 * Apis that handle camera focus functionality.
 *
 * @author  Renden Yoder
 * @version 1.0
 * @since   2018-12-20
 */
package api

import org.json.JSONObject

/**
 * Abstract class for apis that accept two numerical inputs within range of 0 to 100.
 */
abstract class FocusApi(method: String, group: Group, description: String) : Api(
  method = method,
  group = group,
  description = description,
  options = InputType.Numerical to arrayOf(
    FocusTrackingParameters.XAxis.title,
    FocusTrackingParameters.YAxis.title
  )
) {
  /**
   * Exception to be thrown when an invalid numerical arguments are given.
   */
  class InvalidFocusPosition(message: String) : Exception(message)

  /**
   * Outlines all possible Auto-Focus parameters.
   */
  private enum class FocusTrackingParameters(val title: String) {
    XAxis("X Axis Position (0.0 - 100.0)"),
    YAxis("Y Axis Position (0.0 - 100.0)")
  }

  /**
   * Checks to see if numerical inputs passed in by params are valid.
   * @param params List of params.
   * @return Error message or null if no error was detected.
   */
  fun error(params: Array<Any>): String? {
    return when {
      params.size != 2 -> "Illegal number of auto-focus arguments!"
      params[0] !is Number || params[1] !is Number -> {
        "Only numerical values are allowed for auto-focus arguments!"
      }
      params[0] is Number && (params[0] as Number).toDouble() !in 0.0..100.0 -> {
        "X Axis value is not within 0 to 100!"
      }
      params[1] is Number && (params[1] as Number).toDouble() !in 0.0..100.0 -> {
        "Y Axis value is not within 0 to 100!"
      }
      else -> null
    }
  }
}
/**
 * This API provides a function to enable touch AF and set the position.
 */
class SetTouchAFPosition : FocusApi(
  method = "setTouchAFPosition",
  group = Group.TouchAutoFocusPosition,
  description = "Touch Auto-Focus Position"
) {
  override fun parse(params: Array<Any>): Array<Any> {
    val err: String? = error(params)
    // if error message is not null, throw exception and pass it as the message 
    err?.let { throw InvalidFocusPosition(it) }
    return params.take(2).toTypedArray()
  }
}

/**
 * This API provides a function to get current touch AF position.
 */
class GetTouchAFPosition : Api(
  method = "getTouchAFPosition",
  group = Group.TouchAutoFocusPosition,
  description = "Get Touch Auto-Focus Position"
)

/**
 * This API provides a function to cancel Touch AF.
 */
class CancelTouchAFPosition : Api(
  method = "cancelTouchAFPosition",
  group = Group.TouchAutoFocusPosition,
  description = "Cancel Touch Auto-Focus Position"
)

/**
 * This API provides a function to start tracking focus.
 */
class ActTrackingFocus : FocusApi(
  method = "actTrackingFocus",
  group = Group.TrackingFocus,
  description = "Start Tracking Focus"
) {
  override fun parse(params: Array<Any>): Array<Any> {
    val err = error(params)
    // if error message is not null, throw exception and pass it as the message 
    err?.let { throw InvalidFocusPosition(it) }
    val focusArea = JSONObject().apply {
      put("xPosition", params[0])
      put("yPosition", params[1])
    }
    return arrayOf(focusArea)
  }
}

/**
 * This API provides a function to cancel tracking focus.
 */
class CancelTrackingFocus : Api(
  method = "cancelTrackingFocus",
  group = Group.TrackingFocus,
  description = "Cancel Tracking Focus"
)

/**
 * This API provides a function to set a value of tracking focus setting.
 */
class SetTrackingFocus : Api(
  method = "setTrackingFocus",
  group = Group.TrackingFocus,
  description = "Set Tracking Focus Settings",
  options = InputType.Select to arrayOf("On", "Off")
) {
  /**
   * Exception to be thrown when a given tracking focus param is invalid.
   */
  class InvalidTrackingFocusParam(message: String) : Exception(message)

  override fun parse(params: Array<Any>): Array<Any> {
    val state = params.first().toString().toLowerCase()
    return if (state == "on" || state == "off") {
      val focusParam = JSONObject().put("trackingFocus", state.capitalize())
      arrayOf(focusParam)
    } else {
      throw InvalidTrackingFocusParam("On/Off are the only accepted values!")
    }
  }
}

/**
 * This API provides a function to get current tracking focus setting.
 */
class GetTrackingFocus : Api(
  method = "getTrackingFocus",
  group = Group.TrackingFocus,
  description = "Get Tracking Focus Settings"
)

/**
 * This API provides a function to get the supported tracking focus settings. The client
 * should use "getAvailableTrackingFocus" to get the available parameters at the moment.
 */
class GetSupportedTrackingFocus : Api(
  method = "getSupportedTrackingFocus",
  group = Group.TrackingFocus,
  description = "Get Supported Tracking Focus Settings"
)

/**
 * This API provides a function to get current tracking focus setting and the available
 * tracking focus settings at the moment. The available parameters can be changed by user
 * operations and calling APIs.
 */
class GetAvailableTrackingFocus : Api(
  method = "getAvailableTrackingFocus",
  group = Group.TrackingFocus,
  description = "Get Available Tracking Focus Settings"
)
