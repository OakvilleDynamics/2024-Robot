package frc.robot.subsystems;

import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.apriltag.AprilTagFields;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation3d;
import frc.robot.Constants.VisionConstants.ConveyorCamera;
import frc.robot.Constants.VisionConstants.IntakeCamera;
import frc.robot.Constants.VisionConstants.LimeLight;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonPoseEstimator;
import org.photonvision.PhotonPoseEstimator.PoseStrategy;

public class Vision {
  private PhotonCamera limelight;
  private PhotonCamera intakeCamera;
  private PhotonCamera conveyorCamera;
  private PhotonPoseEstimator photonLimeLightPoseEstimator;
  private AprilTagFieldLayout aprilTagFieldLayout;

  public Vision() {
    aprilTagFieldLayout = AprilTagFields.k2024Crescendo.loadAprilTagLayoutField();

    limelight = new PhotonCamera(LimeLight.NAME);
    intakeCamera = new PhotonCamera(IntakeCamera.NAME);
    conveyorCamera = new PhotonCamera(ConveyorCamera.NAME);
    // Cam mounted facing backwards, 12.5 in back from the robot, flat, and facing backwards
    Transform3d robotToLimelight =
        new Transform3d(
            new Translation3d(LimeLight.LENGTH, LimeLight.WIDTH, LimeLight.HEIGHT),
            new Rotation3d(LimeLight.ROLL, LimeLight.PITCH, LimeLight.YAW));

    // Cam mounted facing forwards, 11.75 in front of the robot, 20 degrees down, and facing
    // forwards
    Transform3d robotToIntakeCamera =
        new Transform3d(
            new Translation3d(IntakeCamera.LENGTH, IntakeCamera.WIDTH, IntakeCamera.HEIGHT),
            new Rotation3d(IntakeCamera.ROLL, IntakeCamera.PITCH, IntakeCamera.YAW));

    // Cam mounted facing downwards, 5.5 in front of the robot, 90 degrees down, and facing
    // backwards
    Transform3d robotToConveyorCamera =
        new Transform3d(
            new Translation3d(ConveyorCamera.LENGTH, ConveyorCamera.WIDTH, ConveyorCamera.HEIGHT),
            new Rotation3d(ConveyorCamera.ROLL, ConveyorCamera.PITCH, ConveyorCamera.YAW));

    // Construct a PhotonPoseEstimator with the AprilTagFieldLayout, a PoseStrategy, the camera, and
    // the transform from the robot to the camera.
    photonLimeLightPoseEstimator =
        new PhotonPoseEstimator(
            aprilTagFieldLayout,
            PoseStrategy.CLOSEST_TO_REFERENCE_POSE,
            limelight,
            robotToLimelight);

    // Set the multi tag fallback strategy to closest to reference pose
    photonLimeLightPoseEstimator.setMultiTagFallbackStrategy(
        PoseStrategy.CLOSEST_TO_REFERENCE_POSE);
  }

  /**
   * Get the limelight camera
   *
   * @return the limelight camera
   */
  public PhotonCamera getLimelight() {
    return limelight;
  }

  /**
   * Get the intake camera
   *
   * @return the intake camera
   */
  public PhotonCamera getIntakeCamera() {
    return intakeCamera;
  }

  /**
   * Get the conveyor camera
   *
   * @return the conveyor camera
   */
  public PhotonCamera getConveyorCamera() {
    return conveyorCamera;
  }

  /**
   * Get the AprilTags ID from the limelight
   *
   * @return the AprilTag ID from the limelight
   */
  public int getLimelightAprilTagReading() {
    return limelight.getLatestResult().getBestTarget().getFiducialId();
  }
}
