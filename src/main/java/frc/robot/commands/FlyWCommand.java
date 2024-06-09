package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.FlyWheel;

public class FlyWCommand extends Command {
  private final FlyWheel m_FlyWSubsystem;
  // controller
  // TODO: Change this to the correct controller
  private final Joystick FlyWJoystick = new Joystick(OperatorConstants.COPILOT_CONTROLLER);

  public FlyWCommand(FlyWheel subsystem) {
    m_FlyWSubsystem = subsystem;
    addRequirements(m_FlyWSubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    if (FlyWJoystick.getPOV() == 315 || FlyWJoystick.getPOV() == 0 || FlyWJoystick.getPOV() == 45) {
      m_FlyWSubsystem.enableflywheelfull();
    } else if (FlyWJoystick.getPOV() == 225
        || FlyWJoystick.getPOV() == 180
        || FlyWJoystick.getPOV() == 135) {
      m_FlyWSubsystem.enableflywheelreduced();
    } else if (FlyWJoystick.getRawButton(12)) {
      m_FlyWSubsystem.enableflywheellow();
    } else if (FlyWJoystick.getRawButton(11) || FlyWJoystick.getRawButton(7)) {
      m_FlyWSubsystem.reverseflywheel();
      System.out.println("Flywheels Moving in Reverse");
    } else if (FlyWJoystick.getRawButton(9)) {
      m_FlyWSubsystem.enableflywheelfull(); // Fixed line
    } else {
      m_FlyWSubsystem.disableflywheel();
    }
  }

  @Override
  public void end(boolean interrupted) {
    m_FlyWSubsystem.disableflywheel();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
