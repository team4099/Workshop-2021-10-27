package com.team4099.robot2021

import edu.wpi.first.wpilibj2.command.CommandBase

class RunIntakeInCommand : CommandBase() {
  override fun initialize() {
    Intake.setMotorPower(1.0)
  }

  override fun execute() {

  }

  override fun isFinished(): Boolean {
    return false
  }
}
