package com.team4099.robot2021

import com.revrobotics.CANSparkMax
import com.revrobotics.CANSparkMaxLowLevel
import edu.wpi.first.wpilibj2.command.SubsystemBase

object Intake: SubsystemBase() {
  var ID = 5
  val motor = CANSparkMax(ID, CANSparkMaxLowLevel.MotorType.kBrushless)
  init{
    motor.restoreFactoryDefaults() //resets to factory default
    motor.burnFlash() //saves all motor controller changes
  }
  private fun setMotorPower(power:Double){
    motor.set(power)
  }
}
