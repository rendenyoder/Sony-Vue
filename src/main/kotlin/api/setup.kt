/**
 * Apis that handle camera remote setup functionality. Many Sony Camera models will
 * require the StartRecMode api to be called before any other apis can be called.
 *
 * @author  Renden Yoder
 * @version 1.0
 * @since   2018-12-20
 */
package api

/**
 * This API provides a function to set up camera for shooting function. Some camera models
 * need this API call before starting live view, capturing still image, recording movie,
 * or accessing all other camera shooting functions.
 */
class StartRecMode : Api(
  method = "startRecMode",
  group = Group.CameraSetup,
  description = "Start the Remote Camera Session"
)

/**
 * This API provides a function to stop shooting functions.
 */
class StopRecMode : Api(
  method = "stopRecMode",
  group = Group.CameraSetup,
  description = "Stop the Remote Camera Session"
)
