import com.revrobotics.CANSparkMax
import com.revrobotics.CANSparkMaxLowLevel
import edu.wpi.first.wpilibj2.command.SubsystemBase

object Intake : SubsystemBase() {
  private val intakeSpark =
    CANSparkMax(5, CANSparkMaxLowLevel.MotorType.kBrushless)
    init {
      intakeSpark.restoreFactoryDefaults()
      intakeSpark.burnFlash()
    }

  fun setMotorPower(power: Double){
    intakeSpark.set(power)
  }

}
