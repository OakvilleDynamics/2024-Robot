// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.Elevator;

public class ElevatorControl extends Command {

  private static Elevator ElevatorSubsystem;

  private static Joystick ElevatorJoystick = new Joystick(OperatorConstants.COPILOT_CONTROLLER);

  /** Creates a new PneumaticsControl. */
  public ElevatorControl(Elevator subsystem) {
    ElevatorSubsystem = subsystem;
    addRequirements(subsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (ElevatorJoystick.getThrottle() <= -0.75) {
      ElevatorSubsystem.up();
    } else if (ElevatorJoystick.getThrottle() >= 0.75) {
      ElevatorSubsystem.down();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
