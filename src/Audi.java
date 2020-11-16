public class Audi extends Car {

    public Audi(DriveMode driveMode, double speedLimit, double cabTemp, double accelerationValue) {
        super("Audi", driveMode, speedLimit, cabTemp, accelerationValue);

        driveModeController.setMaxDriveMode(DriveMode.SPORT);
        setDriveMode(getDriveMode());
        this.minSpeedLimit = 20.0;
        this.maxSpeedLimit = 220.0;


        setSpeedLimit(this.speedLimit);
        setCabTemp(this.cabTemp);
    }
}
