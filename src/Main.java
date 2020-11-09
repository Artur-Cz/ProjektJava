public class Main {
    public static void main(String[] args) {
        Car carA = new Car(DriveMode.TURBO, 30.4, 31.2);
        Ferrari ferrA = new Ferrari(DriveMode.TURBO, 70.9, 27.5);
        BMW bmwA = new BMW(DriveMode.ECO, 90.5, 31.2);
        System.out.println(ferrA.getName());
        System.out.println(ferrA.getSpeedLimit());
        System.out.println(bmwA.getCabTemp());
        ferrA.showStatus();
    }
}