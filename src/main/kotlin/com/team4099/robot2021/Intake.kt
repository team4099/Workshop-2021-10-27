package com.team4099.robot2021

import com.revrobotics.CANSparkMax
import com.revrobotics.CANSparkMaxLowLevel
import edu.wpi.first.wpilibj2.command.SubsystemBase

object Intake : SubsystemBase() {
  var IntakeMotor = CANSparkMax(5, CANSparkMaxLowLevel.MotorType.kBrushless)

  init {
    IntakeMotor.restoreFactoryDefaults()
    IntakeMotor.burnFlash()
  }

  fun setMotorPower(power: Double) {
    IntakeMotor.set(power)
  }
}
