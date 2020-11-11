public class BMW extends Car {

    public BMW(DriveMode driveMode, double speedLimit, double cabTemp, double accelerationValue) {

        super("BMW", driveMode, speedLimit, cabTemp, accelerationValue);

        minCabTemp = 0.0;
        maxCabTemp = 35.0;
        cabTempSwitchValue = 0.5;
        isRotatingDriveMode = false;

        setDriveMode(driveMode);
        setSpeedLimit(speedLimit);
        setCabTemp(cabTemp);
    }
}
