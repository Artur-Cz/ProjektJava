public class Car {
    protected final String name;
    private DriveMode driveMode;
    protected double speedLimit;
    protected double cabTemp;
    protected double minCabTemp = 5.0;
    protected double maxCabTemp = 30.0;
    protected double minSpeedLimit = 30.0;
    protected double maxSpeedLimit = 200.0;
    protected double speedLimitSwitchValue = 0.5;
    protected double cabTempSwitchValue = 1.0;
    protected double accelerationValue;
    protected double currentSpeed = 0.0;
    protected DriveModeController driveModeController;

    public Car(String name, DriveMode driveMode, double speedLimit, double cabTemp, double accelerationValue) {
        this.name = name;
        this.driveMode = driveMode;
        this.speedLimit = speedLimit;
        this.cabTemp = cabTemp;
        this.accelerationValue = accelerationValue;
        this.driveModeController = new DriveModeController();
    }

    //
    // Class getters and setters
    //
    public void setDriveMode(DriveMode driveMode) {
        driveModeController.constrainDriveMode(driveMode);
        this.driveMode = driveMode;
    }
    public DriveMode getDriveMode() {
        return this.driveMode;
    }

    public double getSpeedLimit() { return this.speedLimit; }
    public void setSpeedLimit(double speedLimit) { this.speedLimit = constrainSpeedLimit(roundSpeedLimit(speedLimit)); }
    
    public double getCabTemp() { return this.cabTemp; }
    public void setCabTemp(double cabTemp) { this.cabTemp = constrainCabTemp(cabTemp); }

    public DriveModeController getDriveModeController() {
        return this.driveModeController;
    }

    public double getCurrentSpeed() {
        return this.currentSpeed;
    }

    //
    // Rounds the value od speedLimit to one decimal point (either 0 or 5)
    //
    private double roundSpeedLimit(double speedLimit) {
        speedLimit = Math.round(speedLimit * 10.0) / 10.0;
        speedLimit = ((int) ((speedLimit * 2 + 0.5) / 2.0));
        return speedLimit;
    }

    //
    // Verifies value of speedLimit
    //
    public double constrainSpeedLimit(double speedLimit) {
        if (speedLimit > this.maxSpeedLimit) {
            System.out.println("Provided speed limit value is too high.");
            this.speedLimit = this.maxSpeedLimit;
            return this.speedLimit;
        } else if (speedLimit < this.minSpeedLimit) {
            System.out.println("Provided speed limit value is too low.");
            this.speedLimit = this.minSpeedLimit;
            return this.speedLimit;
        } else {
            this.speedLimit = speedLimit;
        }
        return this.speedLimit;
    }

    //
    // Verifies the parameter of cabTemp
    //
    public double constrainCabTemp(double cabTemp) {
        if (cabTemp > maxCabTemp) {
            System.out.println("Provided cabin temperature value is too high.");
            return this.maxCabTemp;
        } else if (cabTemp < minCabTemp) {
            System.out.println("Provided cabin temperature value is too low.");
            return this.minCabTemp;
        } else {
            this.cabTemp = cabTemp;
        }
        return this.cabTemp;
    }

    //
    //Switches the speed limit in the car
    //
    public void speedLimitUp() {
        constrainSpeedLimit((this.speedLimit + this.speedLimitSwitchValue));
        System.out.println("Current speed limit: " + this.speedLimit + " km/h.");
    }

    public void speedLimitDown() {
        constrainSpeedLimit((this.speedLimit - this.speedLimitSwitchValue));
        forceSpeedDown();
        System.out.println("Current speed limit: " + this.speedLimit + " km/h.");

    }

    //
    // Switches the cabin temperature in the car
    //
    public void cabTempUp() {
        constrainCabTemp((this.cabTemp + this.cabTempSwitchValue));
        System.out.println("Current cabin temperature: " + this.cabTemp + " \u00b0C.");
    }

    public void cabTempDown() {
        constrainCabTemp((this.cabTemp - cabTempSwitchValue));
        System.out.println("Current cabin temperature: " + this.cabTemp + " \u00b0C.");
    }

    //
    // Two methods managing car acceleration to full speed
    //
    public void acceleration() {
            if(this.currentSpeed == 0.0) {
                do {
                    double startingSpeed = 0.0;
                    this.currentSpeed += (startingSpeed + this.accelerationValue);
                } while(this.currentSpeed < this.minSpeedLimit);
            } else if((this.currentSpeed + this.accelerationValue) > this.speedLimit) {
                this.currentSpeed = this.speedLimit;
            } else {
                this.currentSpeed += this.accelerationValue;
            }
    }

    public void fullSpeedAcceleration() {
        do {
            acceleration();
        } while(this.currentSpeed < this.speedLimit);
    }

    //
    // Manages slowing down the car
    //
    public void speedDown() {
        if((this.currentSpeed - this.accelerationValue) > this.minSpeedLimit) {
            this.currentSpeed -= this.accelerationValue;
        }
        else {
            this.currentSpeed = this.minSpeedLimit;
        }
        System.out.println("Current speed: " + this.currentSpeed);
    }

    public void forceSpeedDown() {
        do {
            this.currentSpeed -= this.accelerationValue;
            if(this.currentSpeed - this.accelerationValue < this.speedLimit) {
                this.currentSpeed = this.speedLimit;
            }
        } while(this.currentSpeed > this.speedLimit);

    }

    //
    // Displays current parameters of the car
    //
    @Override
    public String toString() {
        return "||************CAR STATUS************||" + "\n  Current cabin temperature: " + cabTemp + " \u00b0C\n  Current speed limit: " + speedLimit + " km/h\n  Current drive mode: " + driveMode + "\n||**********************************||";
    }


}
