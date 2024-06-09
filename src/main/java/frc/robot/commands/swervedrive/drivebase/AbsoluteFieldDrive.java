package frc.robot.commands.swervedrive.drivebase;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.swervedrive.SwerveSubsystem;
import frc.robot.util.swerve.SwerveController;
import frc.robot.util.swerve.SwerveMath;
import java.util.List;
import java.util.function.DoubleSupplier;

public class AbsoluteFieldDrive extends CommandBase {
  private final SwerveSubsystem swerve;
  private final DoubleSupplier vX;
  private final DoubleSupplier vY;
  private final DoubleSupplier heading;

  /**
   * Absolute drive based on field orientation.
   *
   * @param swerve The swerve subsystem
   * @param vX DoubleSupplier that supplies the x-translation joystick input. Should be in the range
   *     -1 to 1 with deadband already accounted for. Positive X is away from the alliance wall.
   * @param vY DoubleSupplier that supplies the y-translation joystick input. Should be in the range
   *     -1 to 1 with deadband already accounted for. Positive Y is towards the left wall when
   *     looking through the driver station glass.
   * @param heading DoubleSupplier that supplies the robot's heading angle.
   */
  public AbsoluteFieldDrive(
      SwerveSubsystem swerve, DoubleSupplier vX, DoubleSupplier vY, DoubleSupplier heading) {
    this.swerve = swerve;
    this.vX = () -> applyDeadband(vX.getAsDouble(), 0.05);  // Applying deadband
    this.vY = () -> applyDeadband(vY.getAsDouble(), 0.05);  // Applying deadband
    this.heading = heading;

    addRequirements(swerve);
  }

  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    // Get the desired chassis speeds based on a 2 joystick module.
    ChassisSpeeds desiredSpeeds =
        swerve.getTargetSpeeds(
            vX.getAsDouble(), vY.getAsDouble(), new Rotation2d(heading.getAsDouble() * Math.PI));

    // Limit velocity to prevent tippy
    Translation2d translation = SwerveController.getTranslation2d(desiredSpeeds);
    translation =
        SwerveMath.limitVelocity(
            translation,
            swerve.getFieldVelocity(),
            swerve.getPose(),
            Constants.LOOP_TIME,
            Constants.ROBOT_MASS,
            List.of(Constants.CHASSIS),
            swerve.getSwerveDriveConfiguration());
    SmartDashboard.putNumber("LimitedTranslation", translation.getX());
    SmartDashboard.putString("Translation", translation.toString());

    // Make the robot move
    swerve.drive(translation, desiredSpeeds.omegaRadiansPerSecond, true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  // Deadband utility function
  public static double applyDeadband(double value, double deadband) {
    if (Math.abs(value) > deadband) {
      return (value - Math.signum(value) * deadband) / (1.0 - deadband);
    } else {
      return 0.0;
    }
  }
}
