// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechanismConstants;

public class Intake extends SubsystemBase {

  private final CANSparkMax intakeMotor1 =
      new CANSparkMax(MechanismConstants.INTAKE_MOTOR_1, CANSparkLowLevel.MotorType.kBrushless);
  private final CANSparkMax intakeMotor2 =
      new CANSparkMax(MechanismConstants.INTAKE_MOTOR_2, CANSparkLowLevel.MotorType.kBrushless);

  /** Creates a new Intake. */
  public Intake() {
    intakeMotor1.setInverted(MechanismConstants.INTAKE_MOTOR_1_INVERTED);
    intakeMotor2.setInverted(MechanismConstants.INTAKE_MOTOR_2_INVERTED);
  }

  /** Sets the intake motors to 100% power. */
  public void enableIntake() {
    intakeMotor1.set(MechanismConstants.INTAKE_MOTOR_SPEED);
    intakeMotor2.set(MechanismConstants.INTAKE_MOTOR_SPEED);
  }

  /** Sets the intake motors to 0% power. */
  public void disableIntake() {
    intakeMotor1.set(0);
    intakeMotor2.set(0);
  }

  /** Sets the intake motors to -100% power. (Reverse direction) */
  public void reverseIntake() {
    intakeMotor1.set(-MechanismConstants.INTAKE_MOTOR_SPEED);
    intakeMotor2.set(-MechanismConstants.INTAKE_MOTOR_SPEED);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
