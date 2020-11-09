public class Ferrari extends Car {
    private final String name;

    public Ferrari(DriveMode driveMode, double speedLimit, double cabTemp) {
        super(driveMode, speedLimit, cabTemp);
        this.name = "Ferrari";
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean checkDriveMode() {
        return getDriveMode() == DriveMode.ECO || getDriveMode() == DriveMode.CITY || getDriveMode() == DriveMode.SPORT || getDriveMode() == DriveMode.TURBO;
    }
}
