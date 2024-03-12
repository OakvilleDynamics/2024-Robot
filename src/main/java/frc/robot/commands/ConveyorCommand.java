// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.Conveyor;

public class ConveyorCommand extends Command {
  private final Conveyor m_ConveyorSubsystem;
  // controller
  private final Joystick ConveyorJoystick = new Joystick(OperatorConstants.COPILOT_CONTROLLER);

  public ConveyorCommand(Conveyor subsystem) {
    m_ConveyorSubsystem = subsystem;
    addRequirements(m_ConveyorSubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    if (ConveyorJoystick.getRawButton(5)
        || ConveyorJoystick.getRawButton(3)
        || ConveyorJoystick.getRawButton(10)) {
      m_ConveyorSubsystem.intakeConveyor();
    } else if (ConveyorJoystick.getRawButton(6)
        || ConveyorJoystick.getRawButton(4)
        || ConveyorJoystick.getRawButton(9)) {
      m_ConveyorSubsystem.reverseConveyor();
      System.out.println("Conveyor Moving in Reverse");
    } else {
      m_ConveyorSubsystem.disableConveyor();
    }
  }

  @Override
  public void end(boolean interrupted) {
    m_ConveyorSubsystem.disableConveyor();
    m_ConveyorSubsystem.intakeConveyor();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
