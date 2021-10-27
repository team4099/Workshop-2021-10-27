object Intake : SubsystemBase() {

  val motor = CANSparkMax(5, MotorType.kBrushless)

  init {
    motor.restoreFactoryDefaults()
    motor.burnFlash()
  }

  fun setMotorPower(power: Double) {
    motor.set(power)
  }
}
