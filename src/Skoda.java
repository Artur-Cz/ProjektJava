public class Skoda extends Car {

    public Skoda(DriveMode driveMode, double speedLimit, double cabTemp, double accelerationValue) {
        super("Skoda", driveMode, speedLimit, cabTemp, accelerationValue);

        this.maxSpeedLimit = 220;
        this.accelerationValue = 8.5;
        this.speedLimitSwitchValue = 1.0;

        setSpeedLimit(speedLimit);
        setCabTemp(cabTemp);
    }
}
