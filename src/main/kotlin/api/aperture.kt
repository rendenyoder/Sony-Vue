/**
 * Apis that handle settings relating to aperture (such as f-stop).
 *
 * @author  Renden Yoder
 * @version 1.0
 * @since   2019-07-14
 */
package api

/**
 * This API provides a function to set a value of F-number.
 */
class SetFNumber : Api(
  method = "setFNumber",
  group = Group.FNumber,
  description = "Set F-Number",
  options = InputType.Numerical to arrayOf(Aperature.FNumber.title)
) {
  /**
   * Outlines all possible parameters for setting the aperture.
   */
  private enum class Aperature(val title: String) {
    FNumber("F-Number")
  }
}

/**
 * This API provides a function to get current F number.
 */
class GetFNumber : Api (
  method = "getFNumber",
  group = Group.FNumber,
  description = "Get F-number"
)

/**
 * This API provides a function to get the supported F numbers. The client should use
 * "getAvailableFNumber" to get the available parameters at the moment.
 */
class GetSupportedFNumber : Api (
  method = "getSupportedFNumber",
  group = Group.FNumber,
  description = "Get Supported F-Number"
)

/**
 * This API provides a function to get current F number and the available F numbers at
 * the moment. The available parameters can be changed by user operations and calling
 * APIs.
 */
class GetAvailableFNumber : Api (
  method = "getAvailableFNumber",
  group = Group.FNumber,
  description = "Get Available F-Number"
)
