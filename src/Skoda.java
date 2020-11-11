public class Skoda extends Car {

    public Skoda(DriveMode driveMode, double speedLimit, double cabTemp, double accelerationValue) {

        super("Skoda", driveMode, speedLimit, cabTemp, accelerationValue);

        speedLimitSwitchValue = 1.0;
        minSpeedLimit = 20.0;
        maxSpeedLimit = 225.0;

        setDriveMode(driveMode);
        setSpeedLimit(speedLimit);
        setCabTemp(cabTemp);
    }
}
