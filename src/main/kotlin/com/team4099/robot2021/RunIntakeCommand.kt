package com.team4099.robot2021

import edu.wpi.first.wpilibj2.command.CommandBase

class RunIntakeCommand : CommandBase() {
  init {
    addRequirements(Intake)
  }

  override fun initialize() {
    Intake.setPower(1.0)
  }

  override fun isFinished(): Boolean {
    return false
  }
}
