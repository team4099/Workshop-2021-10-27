package com.team4099.robot2021

import Intake.setMotorPower
import edu.wpi.first.wpilibj2.command.CommandBase

class RunIntakeInCommand : CommandBase(){
	override fun initialize(){
		setMotorPower(1.0)
	}
	override fun execute(){
		
	}
	override fun isFinished() : Boolean {
		return false
	}
}
