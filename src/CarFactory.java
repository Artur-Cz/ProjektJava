import java.util.ArrayList;
import java.util.Arrays;

public class CarFactory {
    private final ArrayList<Car> carArrayList = new ArrayList<>(Arrays.asList(new Toyota(DriveMode.ECO, 100.0, 21.0, 8.5), new Skoda(DriveMode.CITY, 120.0, 24.0, 9.0), new BMW(DriveMode.SPORT, 140.0, 32.0, 9.5), new Audi(DriveMode.SPORT, 170.0, 22.0, 10.0), new Ferrari(DriveMode.TURBO, 220.0, 18.0, 11.0)));

    Car assignedCar = null;

    //
    //assigns and presents basic parameters of a chosen car
    //
    public void assignCar(String playerCarType) {
        for (Car car : carArrayList) {
            if (playerCarType.toLowerCase().equals(car.name.toLowerCase())) {
                assignedCar = car;
                System.out.println("Car chosen.\n\n" + assignedCar.name.toUpperCase() + "'S" + " PARAMETERS:\n\nMAX SPEED LIMIT: " + assignedCar.maxSpeedLimit + "\nACCELERATION: " + assignedCar.accelerationValue + "\nDRIVE MODE: " + assignedCar.driveModeController.getCurrentDriveMode());
            }
        }
        System.exit(0);
    }
}
