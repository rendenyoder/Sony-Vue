package api

import api.Group.LoopRecording
import api.Group.MovieRecording
import org.junit.Test

/**
 * Tests for movie [Api] classes.
 */
class MovieApiTest : ApiTest() {
  /**
   * [StartMovieRec]
   */
  @Test
  fun startMovieRec() = basicTest("startMovieRec", MovieRecording)

  /**
   * [StopMovieRec]
   */
  @Test
  fun stopMovieRec() = basicTest("stopMovieRec", MovieRecording)

  /**
   * [StartLoopRec]
   */
  @Test
  fun startLoopRec() = basicTest("startLoopRec", LoopRecording)

  /**
   * [StopLoopRec]
   */
  @Test
  fun stopLoopRec() = basicTest("stopLoopRec", LoopRecording)
}