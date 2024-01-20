package frc.robot.commands.swervedrive.drivebase;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.swervedrive.SwerveSubsystem;

/** The only goal of this command is to move either robot or angle centric */
public class SwerveCommand extends CommandBase {

  private SwerveSubsystem swerve;
  private CommandXboxController xbox;

  private Rotation2d targetAngle = new Rotation2d();

  private DriveMode driveMode = DriveMode.AngleCentric;

  private final double MAX_FWD_SENS = 4;
  private final double MAX_STR_SENS = 4;
  private final double MAX_ROT_SENS = 2;
  private final double MIN_SLOW_SENS = 0.2; // For slow mode

  public SwerveCommand(SwerveSubsystem swerve, CommandXboxController xbox) {

    this.swerve = swerve;
    this.xbox = xbox;

    targetAngle = swerve.getHeading();

    addRequirements(swerve);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {

    double envelopeModifier = Math.max(1 - xbox.getLeftTriggerAxis(), MIN_SLOW_SENS);
    double forwardVelocity = -xbox.getLeftX() * MAX_FWD_SENS * envelopeModifier;
    double strafeVelocity = -xbox.getLeftY() * MAX_STR_SENS * envelopeModifier;
    double rotationVelocity = -xbox.getRightX() * MAX_ROT_SENS * envelopeModifier;

    switch (driveMode) {
      case RobotCentric:
        swerve.driveRobotCentric(
            new ChassisSpeeds(forwardVelocity, strafeVelocity, rotationVelocity));
        break;

      case AngleCentric:
        if (Math.abs(xbox.getRightY()) > 0.5) {
          targetAngle = Rotation2d.fromDegrees(90 + 90 * Math.signum(-xbox.getRightY()));
        }
        targetAngle = Rotation2d.fromDegrees(targetAngle.getDegrees() + rotationVelocity);
        swerve.driveAngleCentric(forwardVelocity, strafeVelocity, targetAngle);
        break;

      default:
        break;
    }
  }

  enum DriveMode {
    RobotCentric,
    AngleCentric
  }
}
