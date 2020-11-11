import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Ferrari ferrA = new Ferrari(DriveMode.TURBO, 90.8, 31.0, 10.5);
        BMW bmwA = new BMW(DriveMode.SPORT, 190.0, 34.0, 8.5);

        System.out.println(ferrA);
        ferrA.fullSpeedAcceleration();
    }
}