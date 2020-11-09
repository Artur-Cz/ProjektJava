public class Toyota extends Car {
    private final String name;

    public Toyota(DriveMode driveMode, double speedLimit, double cabTemp, String name) {
        super(driveMode, speedLimit, cabTemp);
        this.name = "Toyota";
    }
}
