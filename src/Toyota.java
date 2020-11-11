public class Toyota extends Car {

    public Toyota(DriveMode driveMode, double speedLimit, double cabTemp, double accelerationValue) {

        super("Toyota", driveMode, speedLimit, cabTemp, accelerationValue);

        setDriveMode(driveMode);
        setSpeedLimit(speedLimit);
        setCabTemp(cabTemp);
    }
}
