public class Ferrari extends Car {

    public Ferrari(DriveMode driveMode, double speedLimit, double cabTemp, double accelerationValue) {

        super("Ferrari", driveMode, speedLimit, cabTemp, accelerationValue);

        maxDriveMode = DriveMode.TURBO;
        isRotatingDriveMode = false;
        speedLimitSwitchValue = 1.0;
        maxSpeedLimit = 240.0;
        minSpeedLimit = 50.0;

        setDriveMode(driveMode);
        setSpeedLimit(speedLimit);
        setCabTemp(cabTemp);
    }
}
