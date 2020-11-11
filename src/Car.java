public abstract class Car {
    private final String name;
    private final double startingSpeed = 0.0;
    private DriveMode driveMode;
    private double speedLimit;
    private double cabTemp;
    protected double minCabTemp = 5.0;
    protected double maxCabTemp = 30.0;
    protected double minSpeedLimit = 30.0;
    protected double maxSpeedLimit = 200.0;
    protected double speedLimitSwitchValue = 0.5;
    protected double cabTempSwitchValue = 1.0;
    protected double accelerationValue;
    protected double currentSpeed = 0.0;
    protected boolean isRotatingDriveMode = false;
    protected boolean isSpeedLimitOn;
    protected DriveMode minDriveMode = DriveMode.ECO;
    protected DriveMode maxDriveMode = DriveMode.SPORT;

    public Car(String name, DriveMode driveMode, double speedLimit, double cabTemp, double accelerationValue) {

        this.name = name;
        this.driveMode = driveMode;
        this.speedLimit = speedLimit;
        this.cabTemp = cabTemp;
        this.accelerationValue = accelerationValue;
    }

    // Class setters
    public DriveMode getDriveMode() { return this.driveMode; }
    public void setDriveMode(DriveMode driveMode) { this.driveMode = constrainDriveMode(driveMode); }
    
    public double getSpeedLimit() { return this.speedLimit; }
    public void setSpeedLimit(double speedLimit) { this.speedLimit = constrainSpeedLimit(roundSpeedLimit(speedLimit)); }
    
    public double getCabTemp() { return this.cabTemp; }
    public void setCabTemp(double cabTemp) { this.cabTemp = constrainCabTemp(cabTemp); }

    // Verifies value of driveMode
    public DriveMode constrainDriveMode(DriveMode driveMode) {
        if (!isRotatingDriveMode) {
            if (driveMode.compareTo(minDriveMode) < 0) {
                System.out.println("Invalid drive mode.");
                return minDriveMode;
            } else if (driveMode.compareTo(maxDriveMode) > 0) {
                System.out.println("Invalid drive mode.");
                return maxDriveMode;
            } else {
                this.driveMode = driveMode;
                return this.driveMode;
            }
        } else if (driveMode.compareTo(minDriveMode) < 0) {
            System.out.println("Setting drive mode to " + maxDriveMode + ".");
            return maxDriveMode;
        } else if (driveMode.compareTo(maxDriveMode) > 0) {
            System.out.println("Setting drive mode to " + minDriveMode + ".");
            return minDriveMode;
        } else {
            this.driveMode = driveMode;
            return this.driveMode;
        }
    }

    // Rounds the value od speedLimit to one decimal point (either 0 or 5)
    private double roundSpeedLimit(double speedLimit) {
        speedLimit = Math.round(speedLimit * 10.0) / 10.0;
        speedLimit = ((int) ((speedLimit * 2 + 0.5) / 2.0));
        return speedLimit;
    }

    // Verifies value of speedLimit
    public double constrainSpeedLimit(double speedLimit) {
        if (speedLimit > maxSpeedLimit) {
            System.out.println("Provided speed limit value is too high.");
            this.speedLimit = maxSpeedLimit;
            return this.speedLimit;
        } else if (speedLimit < minSpeedLimit) {
            System.out.println("Provided speed limit value is too low.");
            this.speedLimit = minSpeedLimit;
            return this.speedLimit;
        } else {
            this.speedLimit = speedLimit;
        }
        return this.speedLimit;
    }

    // Initiates and ends speedLimit control
    public boolean turnSpeedLimitOff() {
        return !this.isSpeedLimitOn;
    }

    public boolean turnSpeedLimitOn() {
        return this.isSpeedLimitOn;
    }

    // Verifies the parameter of cabTemp
    public double constrainCabTemp(double cabTemp) {
        if (cabTemp > maxCabTemp) {
            System.out.println("Provided cabin temperature value is too high.");
            return maxCabTemp;
        } else if (cabTemp < minCabTemp) {
            System.out.println("Provided cabin temperature value is too low.");
            return minCabTemp;
        } else {
            this.cabTemp = cabTemp;
        }
        return this.cabTemp;
    }

    //Switches the drive mode in the car
    public void nextDriveMode() {
        constrainDriveMode(driveMode.countNextDriveMode());
        System.out.println("Setting drive mode to: " + this.driveMode + ".");
    }

    public void prevDriveMode() {
        constrainDriveMode(driveMode.countPreviousDriveMode());
        System.out.println("Setting drive mode to: " + this.driveMode + ".");

    }

    //Switches the speed limit in the car
    public void speedLimitUp() {
        constrainSpeedLimit((this.speedLimit + speedLimitSwitchValue));
        System.out.println("Current speed limit: " + this.speedLimit + " km/h.");
    }

    public void speedLimitDown() {
        constrainSpeedLimit((this.speedLimit - speedLimitSwitchValue));
        System.out.println("Current speed limit: " + this.speedLimit + " km/h.");
    }

    // Switches the cabin temperature in the car
    public void cabTempUp() {
        constrainCabTemp((this.cabTemp + cabTempSwitchValue));
        System.out.println("Current cabin temperature: " + this.cabTemp + " \u00b0C.");
    }

    public void cabTempDown() {
        constrainCabTemp((this.cabTemp - cabTempSwitchValue));
        System.out.println("Current cabin temperature: " + this.cabTemp + " \u00b0C.");
    }

    // Two methods managing car acceleration to full speed
    public void acceleration() {
            if(this.currentSpeed == 0.0) {
                do {
                    this.currentSpeed += (this.startingSpeed + this.accelerationValue);
                    System.out.println(this.currentSpeed);
                } while(this.currentSpeed < this.minSpeedLimit);
            } else if((this.currentSpeed + this.accelerationValue) > this.speedLimit) {
                this.currentSpeed = this.speedLimit;
                System.out.println(this.currentSpeed);
            } else {
                this.currentSpeed += this.accelerationValue;
                System.out.println(this.currentSpeed);
            }
    }

    public void fullSpeedAcceleration() {
        do {
            acceleration();
        } while(this.currentSpeed < this.speedLimit);
    }

    // Displays current parameters of the car
    @Override
    public String toString() {
        return "||************CAR STATUS************||" + "\n  Current cabin temperature: " + getCabTemp() + " \u00b0C\n  Current speed limit: " + getSpeedLimit() + " km/h\n  Current drive mode: " + getDriveMode() + "\n||**********************************||";
    }


}
