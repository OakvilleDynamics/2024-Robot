// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechanismConstants;

public class Conveyor extends SubsystemBase {

  private final CANSparkMax conveyorMotor1 =
      new CANSparkMax(MechanismConstants.CONVEYOR_MOTOR_1, CANSparkLowLevel.MotorType.kBrushless);
  private final CANSparkMax conveyorMotor2 =
      new CANSparkMax(MechanismConstants.CONVEYOR_MOTOR_2, CANSparkLowLevel.MotorType.kBrushless);

  /** Creates a new Conveyor. */
  public Conveyor() {
    conveyorMotor1.setInverted(MechanismConstants.CONVEYOR_MOTOR_1_INVERTED);
    conveyorMotor2.setInverted(MechanismConstants.CONVEYOR_MOTOR_2_INVERTED);
  }

  /** Sets the Conveyor motors to 100% power. */
  public void intakeConveyor() {
    conveyorMotor1.set(MechanismConstants.CONVEYOR_MOTOR_SPEED);
    conveyorMotor2.set(MechanismConstants.CONVEYOR_MOTOR_SPEED);
  }

  /** Sets the Conveyor motors to 0% power. */
  public void disableConveyor() {
    conveyorMotor1.set(0);
    conveyorMotor2.set(0);
  }

  /** Sets the Conveyor motors to -100% power. (Reverse direction) */
  public void reverseConveyor() {
    conveyorMotor1.set(-MechanismConstants.CONVEYOR_MOTOR_SPEED);
    conveyorMotor2.set(-MechanismConstants.CONVEYOR_MOTOR_SPEED);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
