public class Audi extends Car {

    public Audi (DriveMode driveMode, double speedLimit, double cabTemp, double accelerationValue) {

        super("Audi", driveMode, speedLimit, cabTemp, accelerationValue);

        setDriveMode(driveMode);
        setSpeedLimit(speedLimit);
        setCabTemp(cabTemp);
    }
}
