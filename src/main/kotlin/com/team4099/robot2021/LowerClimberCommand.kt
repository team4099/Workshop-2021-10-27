package com.team4099.robot2021

import edu.wpi.first.wpilibj2.command.CommandBase
import edu.wpi.first.wpilibj2.command.WaitCommand

class LowerClimberCommand : CommandBase() {
  init{
    addRequirements(Climber)
  }

  override fun initialize() {
    Climber.setPneumatics(false)
    WaitCommand(1.0)
    Climber.setMotorPower(.5)
  }

  override fun isFinished(): Boolean {
    return false
  }
}
