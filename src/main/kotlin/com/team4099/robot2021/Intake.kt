import com.revrobotics.CANSparkMax
import com.revrobotics.CANSparkMaxLowLevel
import edu.wpi.first.wpilibj2.command.SubsystemBase

object Intake : SubsystemBase() {
	val intakeMotor = CanSparkMax(
		5,
		CANSparkMaxLowLevel.MotorType.kBrushless
	)
	init {
		intakeMotor.restoreFactoryDefaults,
		intakeMotor.burnFlash
	}

	fun motorPower(power: Double){
		intakeMotor.set(power)
	}
}
	
