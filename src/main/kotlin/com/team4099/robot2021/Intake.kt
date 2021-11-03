package com.team4099.robot2021

import com.revrobotics.CANSparkMax
import com.revrobotics.CANSparkMaxLowLevel
import com.revrobotics.SparkMax
import edu.wpi.first.wpilibj.RobotDrive
import edu.wpi.first.wpilibj2.command.SubsystemBase


object Intake : SubsystemBase() {
  fun setMotorpower(power: Double) {
    Motor.set(power)

    TODO("Not yet implemented")
  }

  val Motor = CANSparkMax(5, CANSparkMaxLowLevel.MotorType.kBrushless)
  init {
    {
      Motor.restoreFactoryDefaults()

      Motor.burnFlash()
    }

  }

}

