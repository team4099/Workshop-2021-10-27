package com.team4099.robot2021

import com.team4099.lib.joystick.XboxOneGamepad
import edu.wpi.first.wpilibj2.command.button.Trigger

object ControlBoard {
  private val driver = XboxOneGamepad(0)
  private val operator = XboxOneGamepad(1)

  val shoot = Trigger { operator.yButton }
  val runIntakeIn = Trigger { operator.aButton }
}
