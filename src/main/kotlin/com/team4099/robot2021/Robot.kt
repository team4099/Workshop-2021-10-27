package com.team4099.robot2021

import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj2.command.CommandScheduler

object Robot: TimedRobot() {
  override fun robotPeriodic() {
    CommandScheduler.getInstance().run()
  }
}
