public class Toyota extends Car {

    public Toyota(DriveMode driveMode, double speedLimit, double cabTemp, double accelerationValue) {
        super("Toyota", driveMode, speedLimit, cabTemp, accelerationValue);

        setSpeedLimit(this.speedLimit);
        setCabTemp(this.cabTemp);
    }
}
