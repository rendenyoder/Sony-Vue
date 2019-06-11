/**
 * Apis that handle timer settings for camera actions.
 *
 * @author  Renden Yoder
 * @version 1.0
 * @since   2018-12-20
 */
package api

/**
 * This API provides a function to set a value of self-timer.
 */
class SetSelfTimer : Api(
  method = "setSelfTimer",
  group = Group.SelfTimer,
  description = "Set Timer",
  options = InputType.Select to arrayOf(
    Timer.Zero.title,
    Timer.Two.title,
    Timer.Ten.title
  )
) {
  /**
   * Exception to be thrown when a given [Timer] string is invalid.
   */
  class InvalidTimer(message: String) : Exception(message)

  /**
   * Outlines all possible timer durations.
   */
  enum class Timer(val title: String, val param: Int) {
    Zero("0 Second Delay (Off)", 0),
    Two("2 Second Delay", 2),
    Ten("10 Second Delay", 10);

    companion object {
      fun fromString(title: String): Timer {
        val size = Timer.values().find { it.title == title }
        return size ?: throw InvalidTimer("No timer value for '$title'!")
      }
    }
  }

  override fun parse(params: Array<Any>): Array<Any> {
    val time = params.first()
    return if (time is String) {
      arrayOf(Timer.fromString(time).param)
    } else {
      throw InvalidTimer("Only string parameters are permitted!")
    }
  }
}

/**
 * This API provides a function to get current self-timer setting.
 */
class GetSelfTimer : Api(
  method = "getSelfTimer",
  group = Group.SelfTimer,
  description = "Get Timer"
)

/**
 * This API provides a function to get the supported self-timer settings. The client
 * should use "getAvailableSelfTimer" to get the available parameters at the moment.
 */
class GetSupportedSelfTimer : Api(
  method = "getSupportedSelfTimer",
  group = Group.SelfTimer,
  description = "Get Supported Timer Settings"
)

/**
 * This API provides a function to get current self-timer setting and the available
 * self-timer settings at the moment. The available parameters can be changed by user
 * operations and calling APIs.
 */
class GetAvailableSelfTimer : Api(
  method = "getAvailableSelfTimer",
  group = Group.SelfTimer,
  description = "Get Available Timer Settings"
)
