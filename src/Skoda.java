public class Skoda extends Car {
    private final String name;

    public Skoda(DriveMode driveMode, double speedLimit, double cabTemp, String name) {
        super(driveMode, speedLimit, cabTemp);
        this.name = "Skoda";
    }

    @Override
    public void speedLimitUp() {
        double speedLimit = getSpeedLimit();
        if(speedLimit + 1.0 > 200.0) {
            System.out.println("The speed limit cannot be higher than 200 km/h.");
            speedLimit = 200.0;
        }
        else speedLimit += 1.0;

        System.out.println("Current speed limit: " + speedLimit + " km/h.");
    }
    public void speedLimitDown() {
        double speedLimit = getSpeedLimit();
        if(speedLimit - 1.0 < 30.0) {
            System.out.println("The speed limit cannot be lower than 30 km/h.");
             speedLimit = 30.0;
        }
        else speedLimit -= 1.0;

        setSpeedLimit(speedLimit);
        System.out.println("Current speed limit: " + getSpeedLimit() + " km/h.");
    }
}
