/**
 * Contains class representation of an API that the Sony Remote Camera Server will have
 * available. Each Api object, at a minimum, will contain a description, its action group,
 * and its endpoint.
 *
 * @author  Renden Yoder
 * @version 1.0
 * @since   2018-12-20
 */
package api

import client.Client
import client.SonyClient
import org.json.JSONObject

/**
 * Represents the groupings of remote camera actions.
 * @param description Description for the action group.
 * @param starred Notable action groups.
 * @param show Whether or not to display the action group in the UI.
 */
enum class Group(
  val description: String,
  val starred: Boolean = false,
  val show: Boolean = true
) {
  CameraSetup("Camera Setup"),
  ShootMode("Shooting Mode"),
  StillCapture("Still Capture", true),
  MovieRecording("Movie Recording", true),
  AudioRecording("Audio Recording", true),
  IntervalStillRecording("Interval Still Recording"),
  LoopRecording("Loop Recording"),
  Liveview("Liveview", true),
  LiveviewSize("Liveview Size"),
  LiveviewFrame("Liveview Frame"),
  Zoom("Zoom"),
  ZoomSetting("Zoom Setting"),
  HalfPressShutter("Half Press Shutter"),
  TouchAutoFocusPosition("Touch Auto Focus Position"),
  TrackingFocus("Tracking Focus"),
  ContinuousShootingMode("Continuous Shooting Mode"),
  ContinuousShootingSpeed("Continuous Shooting Speed"),
  SelfTimer("Self Timer"),
  ExposureMode("Exposure Mode", true),
  FocusMode("Focus Mode", true),
  ExposureCompensation("Exposure Compensation"),
  FNumber("F Number", true),
  ShutterSpeed("Shutter Speed", true),
  IsoSpeedRate("ISO Speed Rate", true),
  WhiteBalance("White Balance", true),
  ProgramShift("Program Shift"),
  FlashMode("Flash Mode"),
  StillSize("Still Size"),
  StillQuality("Still Quality"),
  PostviewImageSize("Postview Image Size"),
  MovieFileFormat("Movie File Format"),
  MovieQuality("Movie Quality"),
  SteadyMode("Steady Mode"),
  ViewAngle("View Angle"),
  SceneSelection("Scene Selection"),
  ColorSetting("Color Setting"),
  IntervalTime("Interval Time"),
  LoopRecordingTime("Loop Recording Time"),
  WindNoiseReduction("Wind Noise Reduction"),
  AudioRecordingSetting("Audio Recording Setting"),
  FlipSetting("Flip Setting"),
  TVColorSystem("TV Color System"),
  CameraFunction("Camera Function"),
  IRRemoteControl("IR Remote Control"),
  AutoPowerOff("Auto Power Off"),
  BeepMode("Beep Mode"),
  DateTimeSetting("Date and Time Setting"),
  StorageInformation("Storage Information"),
  EventNotification("Event Notification"),
  ServerInformation("Server Information")
}

/**
 * Represents the type of input expected.
 */
enum class InputType {
  None, Select, String, Numerical;
}

/**
 * Represents a given endpoint of the Sony Camera.
 * @param method The method name of the endpoint.
 * @param group The action group the API is in.
 * @param description The description of the endpoint.
 * @param options A list of all possible options for a given endpoint.
 * @param show Whether or not to display the [Api] in the UI.
 */
abstract class Api(
  val method: String,
  val group: Group,
  val description: String,
  val options: Pair<InputType, Array<String>> = InputType.None to emptyArray(),
  val show: Boolean = true
) {

  /**
   * [Client] object to make requests with.
   */
  var cli: Client = SonyClient

  /**
   * Uses the [cli] to make a request to the specified endpoint.
   * @param params List of params being passed to Sony API endpoint.
   * @return Response of endpoint as [JSONObject].
   */
  fun call(vararg params: Any): JSONObject {
    return cli.request(method, parse(params.map { it }.toTypedArray()))
  }
  
  /**
   * Parses the params to the appropriate value.
   * @param params List of params to be parsed and passed to Sony API endpoint.
   * @return A parsed list of the params.
   */
  open fun parse(params: Array<Any>): Array<Any> = params

  override fun equals(other: Any?) = other != null && other::class == this::class

  override fun hashCode(): Int {
    var result = method.hashCode()
    result = 31 * result + group.hashCode()
    result = 31 * result + description.hashCode()
    result = 31 * result + options.hashCode()
    result = 31 * result + show.hashCode()
    return result
  }
}

/**
 * Factory class for [Api].
 */
class ApiFactory {
  /**
   * Gets an [Api] from a given method name.
   * @param method The method of a supposed [Api].
   * @return The [Api] of the given method.
   */
  fun create(method: String): Api {
    return Class.forName("api.${method.capitalize()}").newInstance() as Api
  }
}

fun main(args: Array<String>) {
  val api = ApiFactory().create("StartRecMode")
  api.options.second.forEach { it.let(::println) }
  println(api.call())
}

// TODO: Finish Writing Tests
// TODO: Setup error codes