package com.team4099.lib.loop

import com.team4099.lib.hal.Clock
import com.team4099.lib.logging.CrashTracker
import com.team4099.lib.logging.Logger
import com.team4099.lib.units.base.Time
import com.team4099.lib.units.base.inMicroseconds
import com.team4099.lib.units.base.inSeconds
import com.team4099.lib.units.base.seconds
import edu.wpi.first.hal.FRCNetComm.tInstances
import edu.wpi.first.hal.FRCNetComm.tResourceType
import edu.wpi.first.hal.HAL
import edu.wpi.first.hal.NotifierJNI
import edu.wpi.first.wpilibj.RobotBase
import edu.wpi.first.wpilibj.Watchdog

open class LooperRobot(
  private val alwaysLooper: Looper,
  private val teleopLooper: Looper,
  private val testLooper: Looper,
  private val autonomousLooper: Looper,
  private val period: Time = 0.02.seconds
) : RobotBase() {
  internal enum class Mode {
    NONE,
    DISABLED,
    AUTONOMOUS,
    TELEOP,
    TEST
  }

  // The C pointer to the notifier object. We don't use it directly, it is
  // just passed to the JNI bindings.
  private val notifier = NotifierJNI.initializeNotifier()
  private var expirationTime = 0.0.seconds
  private var mode: Mode = Mode.NONE
    set(value) {
      if (field != value) {
        when (field) {
          Mode.AUTONOMOUS -> autonomousLooper.onStop()
          Mode.TELEOP -> teleopLooper.onStop()
          Mode.TEST -> testLooper.onStop()
          else -> {}
        }
        when (value) {
          Mode.AUTONOMOUS -> autonomousLooper.onStart()
          Mode.TELEOP -> teleopLooper.onStart()
          Mode.TEST -> testLooper.onStart()
          else -> {}
        }
        field = value
      }
    }
  private val watchdog = Watchdog(period.inSeconds, this::loopOverrunWarning)

  init {
    NotifierJNI.setNotifierName(notifier, "LooperRobot")
    HAL.report(tResourceType.kResourceType_Framework, 7)
    HAL.report(tResourceType.kResourceType_Language, tInstances.kLanguage_Kotlin)
  }

  override fun startCompetition() {
    Logger.startLogging()
    alwaysLooper.onStart()

    // Tell the DS that the robot is ready to be enabled
    HAL.observeUserProgramStarting()

    expirationTime = Clock.fpgaTime + period
    updateAlarm()

    // Loop forever, calling the appropriate loops
    while (true) {
      val curTime = NotifierJNI.waitForNotifierAlarm(notifier)
      if (curTime == 0L) {
        break
      }
      expirationTime += period
      updateAlarm()
      loopFunc()
    }
  }

  private fun loopFunc() {
    watchdog.reset()
    alwaysLooper.onLoop()
    watchdog.addEpoch("alwaysLooper")
    mode =
        when {
          isDisabled -> Mode.DISABLED
          isAutonomous -> Mode.AUTONOMOUS
          isOperatorControl -> Mode.TELEOP
          isTest -> Mode.TEST
          else -> Mode.NONE
        }
    watchdog.addEpoch("Mode transition to $mode")

    try {
      when (mode) {
        Mode.AUTONOMOUS -> autonomousLooper.onLoop()
        Mode.TELEOP -> teleopLooper.onLoop()
        Mode.TEST -> testLooper.onLoop()
        else -> {
        }
      }
    } catch (t: Throwable) {
      CrashTracker.logThrowableCrash("$mode onLoop", t)
    }
    watchdog.addEpoch("$mode loop")
    Logger.saveLogs()
    watchdog.addEpoch("Saved logs")
  }

  private fun loopOverrunWarning() {
    Logger.addEvent("LooperRobot", "")
  }

  /** Update the alarm hardware to reflect the next alarm. */
  private fun updateAlarm() {
    NotifierJNI.updateNotifierAlarm(notifier, expirationTime.inMicroseconds.toLong())
  }

  override fun endCompetition() {
    NotifierJNI.stopNotifier(notifier)
  }

  protected fun finalize() {
    NotifierJNI.stopNotifier(notifier)
    NotifierJNI.cleanNotifier(notifier)
  }
}
