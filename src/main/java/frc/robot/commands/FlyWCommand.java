// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.FlyWheel;

public class FlyWCommand extends Command {
  private final FlyWheel m_FlyWSubsystem;
  // controller
  // TODO: Change this to the correct controller
  private final Joystick Joystick = new Joystick(1);

  public FlyWCommand(FlyWheel subsystem) {
    m_FlyWSubsystem = subsystem;
    addRequirements(m_FlyWSubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    if (Joystick.getPOV() != -1) {
      m_FlyWSubsystem.enableflywheel();
    } else if (Joystick.getRawButton(7) == true) {
      m_FlyWSubsystem.reverseflywheel();
      System.out.println("Flywheels Moving in Reverse");
    } else {
      m_FlyWSubsystem.disableflywheel();
    }
  }

  @Override
  public void end(boolean interrupted) {
    m_FlyWSubsystem.disableflywheel();
    m_FlyWSubsystem.enableflywheel();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
