public enum DriveMode {
    MIN_LIMITER, ECO, CITY, SPORT, TURBO, MAX_LIMITER;

    private static final DriveMode[] vals = values();

    //
    //both methods manage counting and returning the integer value of next or previous drive mode
    //
    public DriveMode countNextDriveMode()
    {
        return vals[(this.ordinal()+1) % vals.length];
    }

    public DriveMode countPreviousDriveMode() {
        return vals[(this.ordinal()-1) % vals.length];
    }
}


