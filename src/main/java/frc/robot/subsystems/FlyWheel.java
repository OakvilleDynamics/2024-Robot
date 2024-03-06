// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechanismConstants;

public class FlyWheel extends SubsystemBase {

  private final CANSparkMax flywheelMotor1 =
      new CANSparkMax(MechanismConstants.FLYWHEEL_MOTOR_1, CANSparkLowLevel.MotorType.kBrushless);
  private final CANSparkMax flywheelMotor2 =
      new CANSparkMax(MechanismConstants.FLYWHEEL_MOTOR_2, CANSparkLowLevel.MotorType.kBrushless);

  /** Creates a new flywheel. */
  public FlyWheel() {
    flywheelMotor1.setInverted(MechanismConstants.FLYWHEEL_MOTOR_1_INVERTED);
    flywheelMotor2.setInverted(MechanismConstants.FLYWHEEL_MOTOR_2_INVERTED);
  }

  /** Sets the flywheel motors to 100% power. */
  public void enableflywheelfull() {
    flywheelMotor1.set(MechanismConstants.FLYWHEEL_MOTOR_FULL_SPEED);
    flywheelMotor2.set(MechanismConstants.FLYWHEEL_MOTOR_FULL_SPEED);
  }

  /** Sets the flywheel speed to 65% power. */
  public void enableflywheelreduced() {
    flywheelMotor1.set(MechanismConstants.FLYWHEEL_MOTOR_REDUCED_SPEED);
    flywheelMotor2.set(MechanismConstants.FLYWHEEL_MOTOR_REDUCED_SPEED);
  }

  /** Sets the flywheel motors to 15% */
  public void enableflywheelslow() {
    flywheelMotor1.set(MechanismConstants.FLYWHEEL_MOTOR_SPEED_SLOW);
    flywheelMotor2.set(MechanismConstants.FLYWHEEL_MOTOR_SPEED_SLOW);
  }

  /** Sets the flywheel motors to 0% power. */
  public void disableflywheel() {
    flywheelMotor1.set(0);
    flywheelMotor2.set(0);
  }

  /** Sets the flywheel motors to -100% power. (Reverse direction) */
  public void reverseflywheel() {
    flywheelMotor1.set(-MechanismConstants.FLYWHEEL_MOTOR_SPEED_SLOW);
    flywheelMotor2.set(-MechanismConstants.FLYWHEEL_MOTOR_SPEED_SLOW);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
