import java.util.*;

public enum DriveMode {
    DEFAULT, ECO, CITY, SPORT, TURBO;

    private static DriveMode[] vals = values();

    public DriveMode nextDriveMode()
    {
        return vals[(this.ordinal()+1) % vals.length];
    }

    public DriveMode previousDriveMode()
    {
        return vals[(this.ordinal()-1) % vals.length];
    }
}


