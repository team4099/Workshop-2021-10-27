package com.team4099.robot2021.subsystems

import edu.wpi.first.wpilibj2.command.CommandBase

class LahariCommand:CommandBase(){
  init{
    addRequirements(LahariSubsystem)
  }

  override fun initialize() {
    LahariSubsystem.setPower(1.00)
  }
}
