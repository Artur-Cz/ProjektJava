public class BMW extends Car {
    private final String name;

    public BMW(DriveMode driveMode, double speedLimit, double cabTemp) {
        super(driveMode, speedLimit, cabTemp);
        this.name = "BMW";
    }

    @Override
    public boolean checkCabTemp() {
        return !(getCabTemp() < 0.0) && !(getCabTemp() > 35.0);
    }

    @Override
    public void cabTempUp() {
        if(getCabTemp() + 1.0 > 35.0) {
            System.out.println("The cabin temperature cannot be higher than 30 \u00b0C.");
            setCabTemp(35.0);
        }
        else  {
            double tempChange = (getCabTemp() + 1.0);
            setCabTemp(tempChange);
        }

        System.out.println("Current cabin temperature: " + getCabTemp() + " \u00b0C.");
    }

    @Override
    public void cabTempDown() {
        if(getCabTemp() - 1.0 < 0.0) {
            System.out.println("The cabin temperature cannot be higher than 0 \u00b0C.");
            setCabTemp(0.0);
        }
        else {
            double tempChange = (getCabTemp() - 1.0);
            setCabTemp(tempChange);
        }

        System.out.println("Current cabin temperature: " + getCabTemp() + " \u00b0C.");
    }
}
