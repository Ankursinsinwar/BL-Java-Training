package RouteTrackerSystem;

abstract class Checkpoint {
    protected String checkpointId;
    protected String locationName;
    protected double distanceFromLast;
    protected int expectedDuration;
    protected int actualDuration;

    public Checkpoint(String checkpointId, String locationName, double distanceFromLast, int expectedDuration, int actualDuration) {
        this.checkpointId = checkpointId;
        this.locationName = locationName;
        this.distanceFromLast = distanceFromLast;
        this.expectedDuration = expectedDuration;
        this.actualDuration = actualDuration;
    }

    
    public abstract boolean isCritical();
    public abstract String getType();
    public abstract double calculatePenalty();


    public boolean isDelayed() {
        return actualDuration > expectedDuration;
    }
}

