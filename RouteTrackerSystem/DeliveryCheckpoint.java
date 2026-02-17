package RouteTrackerSystem;

class DeliveryCheckpoint extends Checkpoint {

    public DeliveryCheckpoint(String id, String location, double distance, int expected, int actual) {
        super(id, location, distance, expected, actual);
    }

    @Override
    public boolean isCritical() {
        return true;
    }

    @Override
    public String getType() {
        return "DeliveryCheckpoint";
    }

    @Override
    public double calculatePenalty() {
        if (!isDelayed()) 
            return 0;
        return (actualDuration - expectedDuration) * 2.0;
    }
}
