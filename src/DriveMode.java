public enum DriveMode {
    DEFAULT, ECO, CITY, SPORT, TURBO;

    private static final DriveMode[] vals = values();

    public DriveMode countNextDriveMode()
    {
        return vals[(this.ordinal()+1) % vals.length];
    }

    public DriveMode countPreviousDriveMode() {
        return vals[(this.ordinal()-1) % vals.length];
    }
}


