public class BMW extends Car {

    public BMW(DriveMode driveMode, double speedLimit, double cabTemp, double accelerationValue) {
        super("BMW", driveMode, speedLimit, cabTemp, accelerationValue);

        this.minCabTemp = 0.0;
        this.maxCabTemp = 35.0;
        this.accelerationValue = 9.0;
        setSpeedLimit(this.speedLimit);
        setCabTemp(this.cabTemp);
    }
}
