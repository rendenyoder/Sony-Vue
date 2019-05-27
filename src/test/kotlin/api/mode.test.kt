package api

import api.Group.ContinuousShootingMode
import api.Group.ShootMode
import api.SetContShootingMode.ContShootingModes
import api.SetShootMode.ShootModes
import org.junit.Test

/**
 * Tests for mode [Api] classes.
 */
class ModeApiTest : ApiTest() {
  /**
   * [SetShootMode]
   */
  @Test
  fun setShootMode() = complexTest(
    method = "setShootMode",
    group = ShootMode,
    input = InputType.Select,
    ioMap = mapOf(
      arrayOf(ShootModes.Still.title) to arrayOf(ShootModes.Still.param),
      arrayOf(ShootModes.Movie.title) to arrayOf(ShootModes.Movie.param),
      arrayOf(ShootModes.Audio.title) to arrayOf(ShootModes.Audio.param),
      arrayOf(ShootModes.IntervalStill.title) to arrayOf(ShootModes.IntervalStill.param),
      arrayOf(ShootModes.LoopRec.title) to arrayOf(ShootModes.LoopRec.param)
    )
  )

  /**
   * [GetShootMode]
   */
  @Test
  fun getShootMode() = basicTest("getShootMode", ShootMode)

  /**
   * [GetSupportedShootMode]
   */
  @Test
  fun getSupportedShootMode() = basicTest("getSupportedShootMode", ShootMode)

  /**
   * [GetAvailableShootMode]
   */
  @Test
  fun getAvailableShootMode() = basicTest("getAvailableShootMode", ShootMode)

  /**
   * [SetContShootingMode]
   */
  @Test
  fun setContShootingMode() {
    val continuous = "contShootingMode"
    complexTest(
      method = "setContShootingMode",
      group = ContinuousShootingMode,
      input = InputType.Select,
      ioMap = mapOf(
        arrayOf(ContShootingModes.Single.title) to arrayOf(
          json(continuous to ContShootingModes.Single.param)
        ),
        arrayOf(ContShootingModes.Continuous.title) to arrayOf(
          json(continuous to ContShootingModes.Continuous.param)
        ),
        arrayOf(ContShootingModes.Speed.title) to arrayOf(
          json(continuous to ContShootingModes.Speed.param)
        ),
        arrayOf(ContShootingModes.Burst.title) to arrayOf(
          json(continuous to ContShootingModes.Burst.param)
        ),
        arrayOf(ContShootingModes.MotionShot.title) to arrayOf(
          json(continuous to ContShootingModes.MotionShot.param)
        )
      )
    )
  }

  /**
   * [GetContShootingMode]
   */
  @Test
  fun getContShootingMode() = basicTest("getContShootingMode", ContinuousShootingMode)

  /**
   * [GetSupportedContShootingMode]
   */
  @Test
  fun getSupportedContShootingMode() {
    basicTest("getSupportedContShootingMode", ContinuousShootingMode)
  }

  /**
   * [GetAvailableContShootingMode]
   */
  @Test
  fun getAvailableContShootingMode() {
    basicTest("getAvailableContShootingMode", ContinuousShootingMode)
  }
}