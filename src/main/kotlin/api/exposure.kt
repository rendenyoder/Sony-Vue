/**
 * Apis that handle exposure settings.
 *
 * @author  Renden Yoder
 * @version 1.0
 * @since   2018-06-29
 */
package api

/**
 * This API provides a function to set a value of exposure mode.
 */
class SetExposureMode : Api(
  method = "setExposureMode",
  group = Group.ExposureMode,
  description = "Set Exposure Mode",
  options = InputType.Select to arrayOf(
    ExposureModes.Program.title,
    ExposureModes.Aperture.title,
    ExposureModes.Shutter.title,
    ExposureModes.Manual.title,
    ExposureModes.Intelligent.title,
    ExposureModes.Superior.title
  )
) {
  /**
   * Exception to be thrown when a given [Group.ExposureMode] string is invalid.
   */
  class InvalidExposureMode(message: String) : Exception(message)

  /**
   * Outlines all possible exposure modes.
   */
  enum class ExposureModes(val title: String, val param: String) {
    Program("Program Auto", "Program Auto"),
    Aperture("Aperture Priority", "Aperture"),
    Shutter("Shutter Priority", "Shutter"),
    Manual("Manual Exposure", "Manual"),
    Intelligent("Intelligent Auto", "Intelligent Auto"),
    Superior("Superior Auto", "Superior Auto");

    companion object {
      fun fromString(title: String): ExposureModes {
        val mode = ExposureModes.values().find { it.title == title }
        return mode
          ?: throw InvalidExposureMode("No exposure mode for '$title'!")
      }
    }
  }

  override fun parse(params: Array<Any>): Array<Any> {
    val param = params.first()
    return if (param is String) {
      val mode = ExposureModes.fromString(param).param
      arrayOf(mode)
    } else {
      throw InvalidExposureMode("Only string parameters are permitted!")
    }
  }
}

/**
 * This API provides a function to get current exposure mode.
 */
class GetExposureMode : Api(
  method = "getExposureMode",
  group = Group.ExposureMode,
  description = "Get Exposure Mode"
)

/**
 * This API provides a function to get the supported exposure modes. The client should
 * use "getAvailableExposureMode" to get the available parameters at the moment.
 */
class GetSupportedExposureMode : Api(
  method = "getSupportedExposureMode",
  group = Group.ExposureMode,
  description = "Get Supported Exposure Modes"
)

/**
 * This API provides a function to get current exposure mode and the available exposure
 * modes at the moment. The available parameters can be changed by user operations and
 * calling APIs.
 */
class GetAvailableExposureMode : Api(
  method = "getAvailableExposureMode",
  group = Group.ExposureMode,
  description = "Get Available Exposure Modes"
)

/**
 * This API provides a function to set a value of exposure compensation.
 */
class SetExposureCompensation : Api(
  method = "setExposureCompensation",
  group = Group.ExposureCompensation,
  description = "Set Exposure Compensation",
  options = InputType.Numerical to arrayOf(ExposureCompensation.Compensation.title)
) {
  /**
   * Outlines all possible exposure compensation parameters.
   */
  private enum class ExposureCompensation(val title: String) {
    Compensation("Exposure Compensation")
  }
}

/**
 * This API provides a function to get current exposure compensation value.
 */
class GetExposureCompensation : Api(
  method = "getExposureCompensation",
  group = Group.ExposureCompensation,
  description = "Get Exposure Compensation"
)

/**
 * This API provides a function to get the supported exposure compensation values. The
 * client should use "getAvailableExposureCompensation" to get the available parameters
 * at the moment.
 */
class GetSupportedExposureCompensation : Api(
  method = "getSupportedExposureCompensation",
  group = Group.ExposureCompensation,
  description = "Get Supported Exposure Compensation"
)

/**
 * This API provides a function to get current exposure compensation value and the
 * available exposure compensation values at the moment.
 */
class GetAvailableExposureCompensation : Api(
  method = "getAvailableExposureCompensation",
  group = Group.ExposureCompensation,
  description = "Get Available Exposure Compensation"
)
