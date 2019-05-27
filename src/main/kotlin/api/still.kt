/**
 * Apis that handle camera still capture functionality.
 *
 * @author  Renden Yoder
 * @version 1.0
 * @since   2018-12-20
 */
package api

/**
 * This API provides a function to take picture.
 */
class ActTakePicture : Api(
  method = "actTakePicture",
  group = Group.StillCapture,
  description = "Take A Picture"
)

/**
 * This API provides a function to wait while the camera is taking the picture.
 */
class AwaitTakePicture : Api(
  method = "awaitTakePicture",
  group = Group.StillCapture,
  description = "Wait For Camera To Complete Taking a Picture"
)

/**
 * This API provides a function to take picture while in bulb mode.
 */
class StartBulbShooting : Api(
  method = "startBulbShooting",
  group = Group.StillCapture,
  description = "Start Bulb Shooting"
)

/**
 * This API provides a function to stop taking a picture while in bulb mode.
 */
class StopBulbShooting : Api(
  method = "stopBulbShooting",
  group = Group.StillCapture,
  description = "Stop Bulb Shooting"
)

/**
 * This API provides a function to start continuous shooting.
 */
class StartContShooting : Api(
  method = "startContShooting",
  group = Group.StillCapture,
  description = "Start Continuous Shooting"
)

/**
 * This API provides a function to stop continuous shooting.
 */
class StopContShooting : Api(
  method = "stopContShooting",
  group = Group.StillCapture,
  description = "Stop Continuous Shooting"
)

/**
 * This API provides a function to start interval still recording.
 */
class StartIntervalStillRec : Api(
  method = "startIntervalStillRec",
  group = Group.IntervalStillRecording,
  description = "Start Interval Still Recording"
)

/**
 * This API provides a function to stop interval still recording.
 */
class StopIntervalStillRec : Api(
  method = "stopIntervalStillRec",
  group = Group.IntervalStillRecording,
  description = "Stop Interval Still Recording"
)
