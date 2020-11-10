import java.util.*;

public class Ferrari extends Car {

    public Ferrari(DriveMode driveMode, double speedLimit, double cabTemp) {
        super("Ferrari", driveMode, speedLimit, cabTemp);
    }

    public boolean checkDriveMode() {
        return getDriveMode() == DriveMode.ECO || getDriveMode() == DriveMode.CITY || getDriveMode() == DriveMode.SPORT || getDriveMode() == DriveMode.TURBO;
    }
}
