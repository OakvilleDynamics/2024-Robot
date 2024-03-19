package frc.robot.subsystems;

import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.apriltag.AprilTagFields;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation3d;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonPoseEstimator;
import org.photonvision.PhotonPoseEstimator.PoseStrategy;

public class Vision {
  private PhotonCamera limelight;
  private PhotonCamera intakeCamera;
  private PhotonCamera conveyorCamera;
  private PhotonPoseEstimator photonPoseEstimator;
  private AprilTagFieldLayout aprilTagFieldLayout;

  public Vision() {
    aprilTagFieldLayout = AprilTagFields.k2024Crescendo.loadAprilTagLayoutField();

    limelight = new PhotonCamera("limelight");
    // Cam mounted facing forward, half a meter forward of center, half a meter up from center.
    Transform3d robotToLimelight =
        new Transform3d(new Translation3d(0.5, 0.0, 0.5), new Rotation3d(0, 0, 0));
    // Construct a PhotonPoseEstimator with the AprilTagFieldLayout, a PoseStrategy, the camera, and
    // the transform from the robot to the camera.
    photonPoseEstimator =
        new PhotonPoseEstimator(
            aprilTagFieldLayout,
            PoseStrategy.CLOSEST_TO_REFERENCE_POSE,
            limelight,
            robotToLimelight);
    photonPoseEstimator.setMultiTagFallbackStrategy(PoseStrategy.CLOSEST_TO_REFERENCE_POSE);
    intakeCamera = new PhotonCamera("intake");
    conveyorCamera = new PhotonCamera("conveyor");
  }

  public PhotonCamera getLimelight() {
    return limelight;
  }

  public PhotonCamera getIntakeCamera() {
    return intakeCamera;
  }

  public PhotonCamera getConveyorCamera() {
    return conveyorCamera;
  }

  public int getLimelightAprilTagReading() {
    return limelight.getLatestResult().getBestTarget().getFiducialId();
  }
}
