import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //
        //Examples of different methods applied in practice
        //
        Ferrari ferrA = new Ferrari(DriveMode.TURBO, 250.0, 21.0, 10.0);
        Ferrari ferrB = new Ferrari(DriveMode.ECO, 90.0, 3.0, 12.0);
        BMW bmwA = new BMW(DriveMode.TURBO, 20.3, 34.0, 10.0);
        BMW bmwB = new BMW(DriveMode.CITY, 70.6, -1.0, 10.0);

        System.out.println("\n" + ferrA.toString() + "\n");
        ferrA.getDriveModeController().nextDriveMode();
        System.out.println(ferrA.getDriveMode() + "\n");

        ferrA.speedLimitUp();
        System.out.println(ferrA.getSpeedLimit() + "\n");

        ferrB.fullSpeedAcceleration();
        System.out.println(ferrB.getCurrentSpeed() + "\n");

        ferrB.getDriveModeController().prevDriveMode();
        System.out.println(ferrB.getDriveMode() + "\n");

        bmwA.speedLimitDown();
        System.out.println(bmwA.getSpeedLimit() + "\n");

        bmwA.cabTempUp();
        System.out.println(bmwA.getCabTemp() + "\n");

        bmwB.cabTempDown();
        System.out.println(bmwB.getCurrentSpeed() + "\n");

        bmwB.speedDown();
        System.out.println(bmwB.getCurrentSpeed() + "\n");


        //
        //Example of CarFactory usage
        //
        CarFactory chosenCar = new CarFactory();

        Scanner UserInput = new Scanner(System.in);

        System.out.println("\nWhich car would you like to choose?\nAvailable options:\n\nSKODA\nTOYOTA\nBMW\nAUDI\nFERRARI\n");
        if(UserInput.hasNextLine()) {
            String chosenCarName = UserInput.nextLine();
            chosenCar.assignCar(chosenCarName);
        }
    }
}