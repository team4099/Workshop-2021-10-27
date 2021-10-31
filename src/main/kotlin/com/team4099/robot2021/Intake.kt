import com.revrobotics.CANSparkMax
import com.revrobotics.CANSparkMaxLowLevel
import edu.wpi.first.wpilibj2.command.SubsystemBase

object Intake : SubsystemBase() {

  val motor = CANSparkMax(5, CANSparkMaxLowLevel.MotorType.kBrushless)

  init {
    motor.restoreFactoryDefaults()
    motor.burnFlash()
  }

  fun setMotorPower(power: Double) {
    motor.set(power)
  }
}
