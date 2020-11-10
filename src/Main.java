import java.util.*;

public class Main {
    public static void main(String[] args) {
        Skoda skodA = new Skoda(DriveMode.DEFAULT, 50.0,25.0);
        skodA.prevDriveMode();
        System.out.println(skodA);
    }


}