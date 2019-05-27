/**
 * Apis that handle simulated interaction with the shutter button.
 *
 * @author  Renden Yoder
 * @version 1.0
 * @since   2018-12-20
 */
package api

/**
 * This API provides a function to half-press shutter.
 */
class ActHalfPressShutter : Api (
  method = "actHalfPressShutter",
  group = Group.HalfPressShutter,
  description = "Half Press Shutter"
)

/**
 * This API provides a function to cancel half-press shutter.
 */
class CancelHalfPressShutter : Api (
  method = "cancelHalfPressShutter",
  group = Group.HalfPressShutter,
  description = "Cancel Half Press Shutter"
)
