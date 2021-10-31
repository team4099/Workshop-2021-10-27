import edu.wpi.first.wpilibj2.command.CommandBase

object RunIntakeInCommand : CommandBase() {

  override fun initialize() {
    Intake.setMotorPower(1.0)
  }

  override fun execute() {

  }

  override fun isFinished(): Boolean {
    return false
  }
}
