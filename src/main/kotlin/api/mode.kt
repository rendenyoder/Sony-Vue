/**
 * Apis that handle camera shooting modes. Not all modes will be supported on all Sony
 * camera models.
 *
 * @author  Renden Yoder
 * @version 1.0
 * @since   2018-12-20
 */
package api

import org.json.JSONObject

/**
 * This API provides a function to set a value of shooting mode.
 */
class SetShootMode : Api(
  method = "setShootMode",
  group = Group.ShootMode,
  description = "Set the Shooting Mode",
  options = InputType.Select to arrayOf(
    ShootModes.Still.title,
    ShootModes.Movie.title,
    ShootModes.Audio.title,
    ShootModes.IntervalStill.title,
    ShootModes.LoopRec.title
  )
) {
  /**
   * Exception to be thrown when a given [Group.ShootMode] string is invalid.
   */
  class InvalidShootMode(message: String) : Exception(message)

  /**
   * Outlines all possible shooting modes.
   */
  enum class ShootModes(val title: String, val param: String) {
    Still("Still Shooting Mode", "still"),
    Movie("Movie Shooting Mode", "movie"),
    Audio("Audio Shooting Mode", "audio"),
    IntervalStill("Interval Still Shooting Mode", "intervalstill"),
    LoopRec("Loop Recording Shooting Mode", "looprec");

    companion object {
      fun fromString(title: String): ShootModes {
        val shoot = ShootModes.values().find { it.title == title }
        return shoot
          ?: throw InvalidShootMode("No shooting mode for '$title'!")
      }
    }
  }

  override fun parse(params: Array<Any>): Array<Any> {
    val mode = params.first()
    return if (mode is String) {
      arrayOf(ShootModes.fromString(mode).param)
    } else {
      throw InvalidShootMode("Only string parameters are permitted!")
    }
  }
}

/**
 * This API provides a function to get current camera shooting mode.
 */
class GetShootMode : Api(
  method = "getShootMode",
  group = Group.ShootMode,
  description = "Get Shooting Modes"
)

/**
 * This API provides a function to get the supported shoot modes. The client should use
 * "getAvailableShootMode" to get the available parameters at the moment.
 */
class GetSupportedShootMode : Api(
  method = "getSupportedShootMode",
  group = Group.ShootMode,
  description = "Get Supported Shooting Modes"
)

/**
 * This API provides a function to get current shoot mode and the available shoot modes at
 * the moment. The available parameters can be changed by user operations and calling APIs.
 */
class GetAvailableShootMode : Api(
  method = "getAvailableShootMode",
  group = Group.ShootMode,
  description = "Get Currently Available Shooting Modes"
)

/**
 * This API provides a function to set a value of continuous shooting mode.
 */
class SetContShootingMode : Api(
  method = "setContShootingMode",
  group = Group.ContinuousShootingMode,
  description = "Set Continuous Shooting Mode",
  options = InputType.Select to arrayOf(
    ContShootingModes.Single.title,
    ContShootingModes.Continuous.title,
    ContShootingModes.Speed.title,
    ContShootingModes.Burst.title,
    ContShootingModes.MotionShot.title
  )
) {
  /**
   * Exception to be thrown when a given [Group.ContinuousShootingMode] string is invalid.
   */
  class InvalidContShootingMode(message: String) : Exception(message)

  /**
   * Outlines all possible continuous shooting modes.
   */
  enum class ContShootingModes(val title: String, val param: String) {
    Single("Single Shooting", "Single"),
    Continuous("Continuous Shooting", "Continuous"),
    Speed("Speed Priority Shooing", "Spd Priority Cont."),
    Burst("Burst Shooting", "Burst"),
    MotionShot("MotionShot", "MotionShot");

    companion object {
      fun fromString(title: String): ContShootingModes {
        val shoot = ContShootingModes.values().find { it.title == title }
        return shoot 
          ?: throw InvalidContShootingMode("No continuous shooting mode for '$title'!")
      }
    }
  }

  override fun parse(params: Array<Any>): Array<Any> {
    val param = params.first()
    return if (param is String) {
      val mode = ContShootingModes.fromString(param).param
      val json = JSONObject().put("contShootingMode", mode)
      arrayOf(json)
    } else {
      throw InvalidContShootingMode("Only string parameters are permitted!")
    }
  }
}

/**
 * This API provides a function to get current continuous shooting mode.
 */
class GetContShootingMode : Api(
  method = "getContShootingMode",
  group = Group.ContinuousShootingMode,
  description = "Get Continuous Shooting Mode"
)

/**
 * This API provides a function to get the supported continuous shooting modes. The client
 * should use "getAvailableContShootingMode" to get available parameters at the moment.
 */
class GetSupportedContShootingMode : Api(
  method = "getSupportedContShootingMode",
  group = Group.ContinuousShootingMode,
  description = "Get Supported Continuous Shooting Modes"
)

/**
 * This API provides a function to get current continuous shooting mode and the available
 * continuous shooting modes at the moment. The available parameters can be changed by
 * user operations and calling APIs.
 */
class GetAvailableContShootingMode : Api(
  method = "getAvailableContShootingMode",
  group = Group.ContinuousShootingMode,
  description = "Get Available Continuous Shooting Modes"
)
