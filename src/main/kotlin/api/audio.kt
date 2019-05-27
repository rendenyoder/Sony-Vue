/**
 * Apis that handle audio recording functionality.
 *
 * @author  Renden Yoder
 * @version 1.0
 * @since   2018-12-20
 */
package api

/**
 * This API provides a function to start audio recording.
 */
class StartAudioRec : Api(
  method = "startAudioRec",
  group = Group.AudioRecording,
  description = "Start Recording Audio"
)

/**
 * This API provides a function to stop audio recording.
 */
class StopAudioRec : Api(
  method = "stopAudioRec",
  group = Group.AudioRecording,
  description = "Stop Recording Audio"
)
