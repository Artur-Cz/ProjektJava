public class Ferrari extends Car {

    public Ferrari(DriveMode driveMode, double speedLimit, double cabTemp, double accelerationValue) {
        super("Ferrari", driveMode, speedLimit, cabTemp, accelerationValue);

        getDriveModeController().setRotatingDriveMode(false);
        getDriveModeController().setMaxDriveMode(DriveMode.TURBO);
        getDriveModeController().setMinDriveMode(DriveMode.SPORT);
        getDriveModeController().setCurrentDriveMode(getDriveMode());
        this.minSpeedLimit = 50.0;
        this.maxSpeedLimit = 240.0;
        this.speedLimitSwitchValue = 1.0;

        setSpeedLimit(speedLimit);
        setCabTemp(cabTemp);
    }
}
