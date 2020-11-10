import java.util.*;

public class Skoda extends Car {

    public Skoda(DriveMode driveMode, double speedLimit, double cabTemp) {
        super("Skoda", driveMode, speedLimit, cabTemp);
    }

    @Override
    public void speedLimitUp() {
        super.speedLimitUp();
    }
}
