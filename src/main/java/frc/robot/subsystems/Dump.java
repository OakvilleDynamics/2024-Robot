// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can mhhhodify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.HardwareConstants;
import frc.robot.Constants.PneumaticsConstants.DumpConstants;
import frc.robot.util.Time;

public class Dump extends SubsystemBase {

  // The double solenoid that controls the piston
  private DoubleSolenoid doubleSolenoid =
      new DoubleSolenoid(
          HardwareConstants.REV_PH_ID,
          PneumaticsModuleType.REVPH,
          DumpConstants.IN,
          DumpConstants.OUT);

  /** Creates a new Pneumatics subsystem. */
  public Dump() {
    System.out.println("Pneumatic Dump initialized");
    SmartDashboard.putBoolean(getName(), false);
  }

  /** Opens the piston */
  public void open() {
    doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    SmartDashboard.putBoolean(getName(), true);
  }

  /** Closes the piston */
  public void close() {
    doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    SmartDashboard.putBoolean(getName(), false);
  }

  /** Opens the piston, waits after a delay, then closes the piston */
  public void openThenClose() {
    Time.performThenWait(this::open, 2.0);
    Time.performThenWait(this::close, 0.5);
    Time.performThenWait(this::open, 1);
    close();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
