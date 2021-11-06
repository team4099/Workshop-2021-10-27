package com.team4099.robot2021

import com.revrobotics.CANSparkMax
import com.revrobotics.CANSparkMaxLowLevel
import edu.wpi.first.wpilibj2.command.SubsystemBase

object Intake : SubsystemBase() {
  val intakespark = CANSparkMax(5, CANSparkMaxLowLevel.MotorType.kBrushless)

  init {
    intakespark.restoreFactoryDefaults()
    intakespark.burnFlash()
  }

  fun setPower(p:Double) {
    intakespark.set(p)
  }
}
