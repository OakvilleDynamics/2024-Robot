package frc.robot.subsystems;

import org.photonvision.PhotonCamera;

public class Vision {
    private PhotonCamera limelight;
    private PhotonCamera intakeCamera;
    private PhotonCamera conveyorCamera;

    public Vision() {
        limelight = new PhotonCamera("limelight");
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

    
}
