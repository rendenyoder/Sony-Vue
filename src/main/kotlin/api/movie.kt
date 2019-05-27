/**
 * Apis that handle camera move recording functionality.
 *
 * @author  Renden Yoder
 * @version 1.0
 * @since   2018-12-20
 */
package api

/**
 * This API provides a function to start recording movie.
 */
class StartMovieRec : Api(
  method = "startMovieRec",
  group = Group.MovieRecording,
  description = "Start Recording Movie"
)

/**
 * This API provides a function to stop recording movie.
 */
class StopMovieRec : Api(
  method = "stopMovieRec",
  group = Group.MovieRecording,
  description = "Stop Recording Movie"
)

/**
 * This API provides a function to start loop recording.
 */
class StartLoopRec : Api(
  method = "startLoopRec",
  group = Group.LoopRecording,
  description = "Start Loop Recording"
)

/**
 * This API provides a function to stop loop recording.
 */
class StopLoopRec : Api(
  method = "stopLoopRec",
  group = Group.LoopRecording,
  description = "Stop Loop Recording"
)
