// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.proto.System;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.HardwareConstants;
import frc.robot.Constants.PneumaticsConstants.ElevatorConstants;

public class Elevator extends SubsystemBase {

  // double solenoid to control the pistons */
  private DoubleSolenoid doubleSolenoid =
      new DoubleSolenoid(
          HardwareConstants.REV_PH_ID,
          PneumaticsModuleType.REVPH,
          ElevatorConstants.IN,
          ElevatorConstants.OUT);

  /** Create new pnuematic system */
  public Elevator() {
    System.out.println("Pneumatic Elevator initialized");
    SmartDashboard.putBoolean(getName(), false);
  }

  /** Open pistons to go up */
  public void open() {
    doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    SmartDashboard.putBoolean(getName(), true);
  }

  /** Closes pistons to go down */
  public void close() {
    doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    SmartDashboard.putBoolean(getName(), false);
  }
}
