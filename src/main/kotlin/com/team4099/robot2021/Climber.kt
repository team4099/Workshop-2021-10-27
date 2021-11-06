package com.team4099.robot2021

import com.ctre.phoenix.motorcontrol.can.TalonSRX
import com.revrobotics.CANSparkMax
import com.revrobotics.CANSparkMaxLowLevel
import edu.wpi.first.wpilibj.Solenoid
import edu.wpi.first.wpilibj2.command.SubsystemBase

object Climber : SubsystemBase() {
  val climbersparkRight = CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless)
  val climbersparkLeft = CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushless)
  val climbersolRight = Solenoid(2)
  val climbersolLeft = Solenoid(1)

  init {
    climbersparkRight.restoreFactoryDefaults()
    climbersparkRight.burnFlash()
    climbersparkLeft.restoreFactoryDefaults()
    climbersparkLeft.burnFlash()
  }

  fun setMotorPower(p:Double) {
    climbersparkRight.set(p)
    climbersparkLeft.set(p)
  }

  fun setPneumatics(state:Boolean) {
    climbersolRight.set(state)
    climbersolLeft.set(state)
  }
}
