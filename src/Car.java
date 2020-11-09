public class Car {
    private DriveMode driveMode;
    private double speedLimit;
    private double cabTemp;

    public Car(DriveMode driveMode, double speedLimit, double cabTemp) {
        this.driveMode = driveMode;
        constrainDriveMode();
        speedLimit = Math.round(speedLimit * 10.0)/10.0;
        speedLimit = ((int)(speedLimit * 2 + 0.5)/2.0);
        this.speedLimit = speedLimit;
        constrainSpeedLimit();
        this.cabTemp = cabTemp;
        constrainCabTemp();
    }

    public DriveMode getDriveMode() {
        return this.driveMode;
    }
    public double getSpeedLimit() {
        return this.speedLimit;
    }
    public double getCabTemp() {
        return this.cabTemp;
    }

    public void setDriveMode(DriveMode driveMode) {
        this.driveMode = driveMode;
        constrainDriveMode();
    }
    public boolean checkDriveMode() {
        return driveMode == DriveMode.ECO || driveMode == DriveMode.CITY || driveMode == DriveMode.SPORT;
    }
    private void constrainDriveMode() {
        if(!checkDriveMode()) {
            System.out.println("Invalid drive mode, setting mode to eco.");
            this.driveMode = DriveMode.ECO;
        }
    }

    public void setSpeedLimit(double speedLimit) {
        this.speedLimit = speedLimit;
        constrainSpeedLimit();
    }
    public boolean checkSpeedLimit() {
        return !(this.speedLimit < 30.0) && !(this.speedLimit > 200.0);
    }
    private void constrainSpeedLimit() {
        if(!checkSpeedLimit()) {
            System.out.println("Invalid value, setting minimum speed limit.");
            this.speedLimit = 30.0;
        }
    }

    public void setCabTemp(double cabTemp) {
        this.cabTemp = cabTemp;
        constrainCabTemp();
    }
    public boolean checkCabTemp() {
        return !(cabTemp < 5.0) && !(cabTemp > 30.0);
    }
    private void constrainCabTemp() {
        if(!checkCabTemp()) {
            System.out.println("Invalid temperature value, setting temperature to 21 \u00b0C.");
            this.cabTemp = 21.0;
        }
    }

    //Switches the drive mode in the car
    public DriveMode nextDriveMode() {
        switch (getDriveMode()) {
            case ECO:
                this.driveMode = DriveMode.CITY;
                return this.driveMode;
            case CITY:
                this.driveMode = DriveMode.SPORT;
                return this.driveMode;
            case SPORT:
                this.driveMode = DriveMode.ECO;
                return this.driveMode;
            default:
                return null;
        }
    }
    public DriveMode prevDriveMode() {
        switch (getDriveMode()) {
            case ECO:
                this.driveMode = DriveMode.SPORT;
                return this.driveMode;
            case SPORT:
                this.driveMode = DriveMode.CITY;
                return this.driveMode;
            case CITY:
                this.driveMode = DriveMode.ECO;
                return this.driveMode;
            default:
                return null;
        }
    }

    //Switches the speed limit in the car
    public void speedLimitUp() {
        if(this.speedLimit + 0.5 > 200.0) {
            System.out.println("The speed limit cannot be higher than 200 km/h.");
            this.speedLimit = 200.0;
        } else {
            this.speedLimit += 0.5;
        }
        System.out.println("Current speed limit: " + this.speedLimit + " km/h.");
    }
    public void speedLimitDown() {
        if(this.speedLimit - 0.5 < 30.0) {
            System.out.println("The speed limit cannot be lower than 30 km/h.");
            this.speedLimit = 30.0;
        }
        else this.speedLimit -= 0.5;

        System.out.println("Current speed limit: " + this.speedLimit + " km/h.");
    }

    public void cabTempUp() {
        if(this.cabTemp + 1.0 > 30.0) {
            System.out.println("The cabin temperature cannot be higher than 30 \u00b0C.");
            this.cabTemp = 30.0;
        }
        else this.cabTemp +=1.0;

        System.out.println("Current cabin temperature: " + this.cabTemp + " \u00b0C.");
    }
    public void cabTempDown() {
        if (this.cabTemp + 1.0 < 5.0) {
            System.out.println("The cabin temperature cannot be lower than 5 \u00b0C.");
            this.cabTemp = 5.0;
        }
        else this.cabTemp -= 1.0;

        System.out.println("Current cabin temperature: " + this.cabTemp + " \u00b0C.");
    }

    public void showStatus() {
        System.out.println("Current cabin temperature: " + getCabTemp() + " \u00b0C, current speed limit: " + getSpeedLimit() + " km/h, current drive mode: " + getDriveMode());
    }
}
