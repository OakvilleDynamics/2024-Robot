package frc.robot.commands.swervedrive.drivebase;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.swervedrive.SwerveSubsystem;
import java.util.function.DoubleSupplier;

// will need to update commandbase in the future, but attempting to see if this fixes the strafing issues currently being encountered
public class AbsoluteFieldDrive extends CommandBase {
  private static final double DEADBAND = 0.1;
  private final SwerveSubsystem swerveSubsystem;
  private final DoubleSupplier forward;
  private final DoubleSupplier strafe;
  private final DoubleSupplier rotation;

  public AbsoluteFieldDrive(
      SwerveSubsystem swerveSubsystem,
      DoubleSupplier forward,
      DoubleSupplier strafe,
      DoubleSupplier rotation) {
    this.swerveSubsystem = swerveSubsystem;
    this.forward = forward;
    this.strafe = strafe;
    this.rotation = rotation;
    addRequirements(swerveSubsystem);
  }

  private double applyDeadband(double value) {
    return Math.abs(value) > DEADBAND ? value : 0.0;
  }

  @Override
  public void initialize() {
    // Initialization code if needed
  }

  @Override
  public void execute() {
    swerveSubsystem.drive(
        new Translation2d(
            applyDeadband(forward.getAsDouble()), applyDeadband(strafe.getAsDouble())),
        applyDeadband(rotation.getAsDouble()),
        true // Assuming the drive method requires a boolean for field-relative
        );
  }

  @Override
  public void end(boolean interrupted) {
    swerveSubsystem.drive(new Translation2d(0, 0), 0, true); // Stop the robot when the command ends
  }

  @Override
  public boolean isFinished() {
    return false; // Ensure the command never finishes on its own
  }
}
