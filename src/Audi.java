public class Audi extends Car {
    private final String name;

    public Audi(DriveMode driveMode, double speedLimit, double cabTemp, String name) {
        super(driveMode, speedLimit, cabTemp);
        this.name = "Audi";
    }
}
