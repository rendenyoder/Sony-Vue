package api

import api.Group.AudioRecording
import org.junit.Test

/**
 * Tests for audio [Api] classes.
 */
class AudioApiTest : ApiTest() {
  /**
   * [StartAudioRec]
   */
  @Test
  fun startAudioRec() = basicTest("startAudioRec", AudioRecording)

  /**
   * [StopAudioRec]
   */
  @Test
  fun stopAudioRec() = basicTest("stopAudioRec", AudioRecording)
}