// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.Intake;

public class IntakeCommand extends Command {
  private final Intake m_intakeSubsystem;
  // controller
  // TODO: Change this to the correct controller
  private final Joystick IntakeJoystick = new Joystick(OperatorConstants.COPILOT_CONTROLLER);

  public IntakeCommand(Intake subsystem) {
    m_intakeSubsystem = subsystem;
    addRequirements(m_intakeSubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    if (IntakeJoystick.getRawButton(5)) {
      // sushi + Conveyor in
      m_intakeSubsystem.enableIntakeSushi();
    } else if (IntakeJoystick.getRawButton(3)) {
      // front + Conveyor in
      m_intakeSubsystem.enableIntakeFront();
    } else if (IntakeJoystick.getRawButton(4)) {
      // front + Conveyor out
      m_intakeSubsystem.reverseIntakeFront();
      System.out.println("Front Rollers Moving in Reverse");
    } else if (IntakeJoystick.getRawButton(6)) {
      // sushi + Conveyor out
      m_intakeSubsystem.reverseIntakeSushi();
      System.out.println("Sushi Rollers Moving in Reverse");
    } else {
      m_intakeSubsystem.disableIntake();
    }
  }

  @Override
  public void end(boolean interrupted) {
    m_intakeSubsystem.disableIntake();
    m_intakeSubsystem.enableIntakeSushi();
    m_intakeSubsystem.enableIntakeFront();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
