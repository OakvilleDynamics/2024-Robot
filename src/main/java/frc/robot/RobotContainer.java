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

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final SwerveSubsystem m_swerveSubsystem = new SwerveSubsystem(new File(Filesystem.getDeployDirectory(), "swerve"));

  private final XboxController m_driverController = new XboxController(OperatorConstants.DRIVER_CONTROLLER_PORT);

  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    // Set the default command for the swerve subsystem
    setDriveMode();
  }

  private void configureButtonBindings() {
    // Example of button binding:
    new JoystickButton(m_driverController, XboxController.Button.kA.value)
        .whenPressed(new ExampleCommand(m_exampleSubsystem));
  }

  private void configureBindings() {
    new JoystickButton(m_driverController, XboxController.Button.kA.value)
        .whenPressed(new InstantCommand(() -> m_swerveSubsystem.zeroGyro()));
    new JoystickButton(m_driverController, XboxController.Button.kB.value)
        .whileHeld(Commands.deferredProxy(() -> m_swerveSubsystem.aimAtTarget()));
    new JoystickButton(m_driverController, XboxController.Button.kX.value)
        .whileHeld(Commands.deferredProxy(() -> m_swerveSubsystem.driveToPose(new Pose2d(new Translation2d(4, 4), Rotation2d.fromDegrees(0)))));
    new JoystickButton(m_driverController, XboxController.Button.kY.value)
        .whileHeld(new InstantCommand(() -> m_swerveSubsystem.lock(), m_swerveSubsystem));
  }

  private void setDriveMode() {
    m_swerveSubsystem.setDefaultCommand(new AbsoluteDriveAdv(
      m_swerveSubsystem,
      () -> m_driverController.getLeftY(),
      () -> m_driverController.getLeftX(),
      () -> m_driverController.getRightX(),
      () -> m_driverController.getBButton(),
      () -> m_driverController.getAButton(),
      () -> m_driverController.getXButton(),
      () -> m_driverController.getYButton()
    ));
  }

  public Command getAutonomousCommand() {
    // Example autonomous command
    return new ExampleCommand(m_exampleSubsystem);
  }

  public void setMotorBrake(boolean brake) {
    m_swerveSubsystem.setMotorBrake(brake);
  }
}
