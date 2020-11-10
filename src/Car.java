import java.util.*;

public class Car {
    private final String name;
    private DriveMode driveMode;
    private double speedLimit;
    private double cabTemp;
    private final double minCabTemp = 5.0;
    private final double maxCabTemp = 30.0;
    private final double minSpeedLimit = 30.0;
    private final double maxSpeedLimit = 200.0;
    private final double speedLimitSwitchValue = 0.5;
    private final double cabTempSwitchValue = 1.0;
    private final boolean isRotatingDriveMode = false;
    private final DriveMode minDriveMode = DriveMode.ECO;
    private final DriveMode maxDriveMode = DriveMode.SPORT;

    public Car(String name, DriveMode driveMode, double speedLimit, double cabTemp) {
        this.name = name;
        this.driveMode = constrainDriveMode(driveMode);
        this.speedLimit = constrainSpeedLimit(roundSpeedLimit(speedLimit));
        this.cabTemp = constrainCabTemp(cabTemp);
    }

    // Class getters
    public String getName() {
        return name;
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

    // Assigns value to driveMode
    public void setDriveMode(DriveMode driveMode) {
        this.driveMode = constrainDriveMode(driveMode);
    }

        private DriveMode constrainDriveMode(DriveMode driveMode) {
        if(!isRotatingDriveMode) {
            if(driveMode.compareTo(minDriveMode)<0) {
                System.out.println("Invalid drive mode.");
                return minDriveMode;
            }
            else if(driveMode.compareTo(maxDriveMode)>0) {
                System.out.println("Invalid drive mode.");
                return maxDriveMode;
            }
            else {
                this.driveMode = driveMode;
                return this.driveMode;
            }
        }
        else if(driveMode.compareTo(minDriveMode)<0) {
                System.out.println("Setting drive mode to " + maxDriveMode + ".");
                return maxDriveMode;
            }
        else if(driveMode.compareTo(maxDriveMode)>0) {
                System.out.println("Setting drive mode to " + minDriveMode + ".");
                return minDriveMode;
            }
        else {
            this.driveMode = driveMode;
            System.out.println("Setting drive mode to " + this.driveMode + ".");
            return this.driveMode;
        }
    }

    // Assigns value to speedLimit
    public void setSpeedLimit(double speedLimit) {
        this.speedLimit = constrainSpeedLimit(speedLimit);
    }

    // Rounds the value od speedLimit to one decimal point (either 0 or 5)
    private double roundSpeedLimit(double speedLimit) {
        speedLimit = Math.round(speedLimit * 10.0)/10.0;
        speedLimit = ((int)((speedLimit * 2 + 0.5)/2.0));
        return speedLimit;
    }

    // Verifies the parameter of speedLimit
       private double constrainSpeedLimit(double speedLimit) {
        if(speedLimit > maxSpeedLimit) {
            System.out.println("Invalid value, setting the speed limit of " + maxSpeedLimit + " km/h.");
            return maxSpeedLimit;
        }
        else if(speedLimit < minSpeedLimit) {
            System.out.println("Invalid value, setting the speed limit of " + minSpeedLimit + " km/h.");
            return minSpeedLimit;
        }
        else {
            this.speedLimit = speedLimit;
        } return this.speedLimit;
    }

    // Assigns value to cabTemp
    public void setCabTemp(double cabTemp) {
        this.cabTemp = cabTemp;
        constrainCabTemp(cabTemp);
    }

    // Verifies the parameter of cabTemp
    private double constrainCabTemp(double cabTemp) {
        if(cabTemp > maxCabTemp) {
            System.out.println("Invalid temperature value, setting temperature to " + maxCabTemp + " \u00b0C.");
            return maxCabTemp;
        }
        else if(cabTemp < minCabTemp) {
            System.out.println("Invalid temperature value, setting temperature to " + minCabTemp + " \u00b0C.");
            return minCabTemp;
        }
        else {
            this.cabTemp = cabTemp;
        }
        return this.cabTemp;
    }

    //Switches the drive mode in the car
    public void nextDriveMode() {
        constrainDriveMode(driveMode.nextDriveMode());
        System.out.println("Setting drive mode to: " + this.driveMode + ".");
    }

    public void prevDriveMode() {
        constrainDriveMode(driveMode.previousDriveMode());
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

    // Displays current parameters of the car
    public String toString() {
        return "||************CAR STATUS************||" + "\n  Current cabin temperature: " + getCabTemp() + " \u00b0C\n  Current speed limit: " + getSpeedLimit() + " km/h\n  Current drive mode: " + getDriveMode() + "\n||**********************************||";
    }
}
