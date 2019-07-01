package api

import api.Group.ExposureCompensation
import api.Group.ExposureMode
import api.SetExposureMode.ExposureModes
import org.junit.Test

/**
 * Tests for exposure [Api] classes.
 */
class ExposureApiTest : ApiTest() {
  /**
   * [SetExposureMode]
   */
  @Test
  fun setExposureMode() = complexTest(
    method = "setExposureMode",
    group = ExposureMode,
    input = InputType.Select,
    ioMap = mapOf(
      arrayOf(ExposureModes.Program.title) to arrayOf(ExposureModes.Program.param),
      arrayOf(ExposureModes.Aperture.title) to arrayOf(ExposureModes.Aperture.param),
      arrayOf(ExposureModes.Shutter.title) to arrayOf(ExposureModes.Shutter.param),
      arrayOf(ExposureModes.Manual.title) to arrayOf(ExposureModes.Manual.param),
      arrayOf(ExposureModes.Intelligent.title) to arrayOf(ExposureModes.Intelligent.param),
      arrayOf(ExposureModes.Superior.title) to arrayOf(ExposureModes.Superior.param)
    )
  )

  /**
   * [GetExposureMode]
   */
  @Test
  fun getExposureMode() {
    basicTest("getExposureMode", ExposureMode)
  }

  /**
   * [GetSupportedExposureMode]
   */
  @Test
  fun getSupportedExposureMode() {
    basicTest("getSupportedExposureMode", ExposureMode)
  }

  /**
   * [GetAvailableExposureMode]
   */
  @Test
  fun getAvailableExposureMode() {
    basicTest("getAvailableExposureMode", ExposureMode)
  }

  /**
   * [SetExposureCompensation]
   *
   * This test is sort of a hack as the endpoint parameters vary widely based on camera
   * model.
   */
  @Test
  fun setExposureCompensation() = complexTest(
    method = "SetExposureCompensation",
    group = ExposureCompensation,
    input = InputType.Numerical,
    ioMap = mapOf(
      arrayOf(10.0) to arrayOf(10.0)
    )
  )

  /**
   * [GetExposureCompensation]
   */
  @Test
  fun getExposureCompensation() {
    basicTest("getExposureCompensation", ExposureCompensation)
  }

  /**
   * [GetSupportedExposureCompensation]
   */
  @Test
  fun getSupportedExposureCompensation() {
    basicTest("getSupportedExposureCompensation", ExposureCompensation)
  }

  /**
   * [GetAvailableExposureCompensation]
   */
  @Test
  fun getAvailableExposureCompensation() {
    basicTest("getAvailableExposureCompensation", ExposureCompensation)
  }
}