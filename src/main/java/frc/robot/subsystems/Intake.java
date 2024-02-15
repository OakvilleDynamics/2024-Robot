// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechanismConstants;

public class Intake extends SubsystemBase {

  private final CANSparkMax intakeSushi =
      new CANSparkMax(MechanismConstants.INTAKE_MOTOR_SUSHI, CANSparkLowLevel.MotorType.kBrushless);
  private final CANSparkMax intakeFront =
      new CANSparkMax(MechanismConstants.INTAKE_MOTOR_FRONT, CANSparkLowLevel.MotorType.kBrushless);

  /** Creates a new Intake. */
  public Intake() {
    intakeSushi.setInverted(MechanismConstants.INTAKE_MOTOR_SUSHI_INVERTED);
    intakeFront.setInverted(MechanismConstants.INTAKE_MOTOR_FRONT_INVERTED);
  }

  /** Sets the intake motors to 100% power. */
  public void enableIntake() {
    intakeSushi.set(MechanismConstants.INTAKE_MOTOR_SPEED * 0.66);
    intakeFront.set(MechanismConstants.INTAKE_MOTOR_SPEED);
  }

  /** Sets the intake motors to 0% power. */
  public void disableIntake() {
    intakeSushi.set(0);
    intakeFront.set(0);
  }

  /** Sets the intake motors to -100% power. (Reverse direction) */
  public void reverseIntake() {
    intakeSushi.set(-MechanismConstants.INTAKE_MOTOR_SPEED * 0.66);
    intakeFront.set(-MechanismConstants.INTAKE_MOTOR_SPEED);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
