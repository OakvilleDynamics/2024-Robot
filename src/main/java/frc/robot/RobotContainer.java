// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ConveyorCommand;
import frc.robot.commands.DumpControl;
import frc.robot.commands.ElevatorControl;
import frc.robot.commands.FlyWCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.auto.SHOOTCONVEYOR;
import frc.robot.commands.auto.SHOOTFLYS;
import frc.robot.commands.autoCommands.dumpBed;
import frc.robot.commands.swervedrive.drivebase.AbsoluteDriveAdv;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Dump;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.FlyWheel;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Vision;
import frc.robot.subsystems.swervedrive.SwerveSubsystem;
import java.io.File;
import org.littletonrobotics.junction.networktables.LoggedDashboardChooser;
import org.photonvision.PhotonCamera;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final SwerveSubsystem swerveSubsystem = new SwerveSubsystem();
  private final Conveyor conveyor = new Conveyor();
  private final Dump dump = new Dump();
  private final Elevator elevator = new Elevator();
  private final FlyWheel flyWheel = new FlyWheel();
  private final Intake intake = new Intake();
  private final Vision vision = new Vision();

  private final CommandXboxController xboxController =
      new CommandXboxController(OperatorConstants.XBOX_CONTROLLER_PORT);
  private final CommandJoystick joystick = new CommandJoystick(OperatorConstants.JOYSTICK_PORT);

  // Deadband utility function
  public static double applyDeadband(double value, double deadband) {
      if (Math.abs(value) > deadband) {
          return (value - Math.signum(value) * deadband) / (1.0 - deadband);
      } else {
          return 0.0;
      }
  }

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {
    // Configure the trigger bindings here...
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then calling passing it to a
   * {@link JoystickButton}.
   */
  private void configureButtonBindings() {
    // Configure your button bindings here...
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return new InstantCommand();
  }

  // Somewhere in the RobotContainer class where the joystick values are read
  double rightYAxis = xboxController.getRightY();
  rightYAxis = applyDeadband(rightYAxis, 0.05);  // Applying a deadband of 0.05
}
