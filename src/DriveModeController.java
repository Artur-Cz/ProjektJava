public class DriveModeController {

    DriveMode currentDriveMode;
    DriveMode minDriveMode;
    DriveMode maxDriveMode;
    boolean isRotatingDriveMode;

    public DriveModeController() {
        this.currentDriveMode = DriveMode.CITY;
        this.minDriveMode = DriveMode.ECO;
        this.maxDriveMode = DriveMode.SPORT;
        this.isRotatingDriveMode = true;
    }
    //
    //getters and setters
    //
    public DriveMode getCurrentDriveMode() {
        return currentDriveMode;
    }
    public void setCurrentDriveMode(DriveMode currentDriveMode) {
        constrainDriveMode(currentDriveMode);
        this.currentDriveMode = currentDriveMode;
    }

    public void setMaxDriveMode(DriveMode maxDriveMode) {
        this.maxDriveMode = maxDriveMode;
    }

    public void setMinDriveMode(DriveMode minDriveMode) {
        this.minDriveMode = minDriveMode;
    }

    public void setRotatingDriveMode(boolean rotatingDriveMode) {
        isRotatingDriveMode = rotatingDriveMode;
    }

    //
    // Verifies value of driveMode
    //
    public void constrainDriveMode(DriveMode driveMode) {
        if (!this.isRotatingDriveMode) {
            if (driveMode.compareTo(this.minDriveMode) < 0) {
                System.out.println("Invalid drive mode.");
                this.currentDriveMode = this.minDriveMode;
            } else if (driveMode.compareTo(this.maxDriveMode) > 0) {
                System.out.println("Invalid drive mode.");
                this.currentDriveMode = this.maxDriveMode;
            } else {
                this.currentDriveMode = driveMode;
            }
        } else if (driveMode.compareTo(this.minDriveMode) < 0) {
            System.out.println("Setting drive mode to: " + this.maxDriveMode + ".");
            this.currentDriveMode = this.maxDriveMode;
        } else if (driveMode.compareTo(this.maxDriveMode) > 0) {
            System.out.println("Setting drive mode to: " + this.minDriveMode + ".");
            this.currentDriveMode = this.minDriveMode;
        } else {
            this.currentDriveMode = driveMode;
        }
    }

    //
    //Switches the drive mode in the car
    //
    public void nextDriveMode() {
        constrainDriveMode(currentDriveMode.countNextDriveMode());
    }

    public void prevDriveMode() {
        constrainDriveMode(currentDriveMode.countPreviousDriveMode());
    }
}
