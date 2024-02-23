package frc.robot.util;

import edu.wpi.first.wpilibj.Timer;

public class Time {

  /**
   * Performs an action then waits for a specified amount of time
   *
   * @param action The action to perform
   * @param delay The delay in seconds
   */
  public static void performThenWait(Runnable action, double delay) {
    double timer = Timer.getFPGATimestamp();
    action.run();
    while (Timer.getFPGATimestamp() - timer < delay) {
      // Wait for the delay
    }
  }
}
