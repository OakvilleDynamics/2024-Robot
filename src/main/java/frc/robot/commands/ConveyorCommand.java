// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Conveyor;

public class ConveyorCommand extends Command {
  private final Conveyor m_ConveyorSubsystem;
  // controller
  // TODO: Change this to the correct controller
  private final Joystick ConveyorJoystick = new Joystick(1);

  public ConveyorCommand(Conveyor subsystem) {
    m_ConveyorSubsystem = subsystem;
    addRequirements(m_ConveyorSubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    // TODO: Change this to the correct button
    if (ConveyorJoystick.getRawButton(3) == true) {
      m_ConveyorSubsystem.enableConveyor();
      // TODO: Change this to the correct button
    } else if (ConveyorJoystick.getRawButton(4) == true) {
      m_ConveyorSubsystem.reverseConveyor();
      System.out.println("Conveyor Moving in Reverse");
    } else {
      m_ConveyorSubsystem.disableConveyor();
    }
  }

  @Override
  public void end(boolean interrupted) {
    m_ConveyorSubsystem.disableConveyor();
    m_ConveyorSubsystem.enableConveyor();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
