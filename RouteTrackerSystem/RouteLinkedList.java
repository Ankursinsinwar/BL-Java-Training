package RouteTrackerSystem;

class RouteLinkedList<T extends Checkpoint> {

    private class Node {
        T data;
        Node next;
        Node(T data){
             this.data = data; 
             this.next = null;
        }
    }

    private Node head;

    public void addCheckpoint(T checkpoint) {
        Node newNode = new Node(checkpoint);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }

    public boolean removeCheckpoint(String checkpointId) {
        if (head == null) return false;

        if (head.data.checkpointId.equals(checkpointId)) {
            head = head.next;
            return true;
        }

        Node curent = head;
        while (curent.next != null) {
            if (curent.next.data.checkpointId.equals(checkpointId)) {
                curent.next = curent.next.next;
                return true;
            }
            curent = curent.next;
        }
        return false;
    }

    public T findCheckpoint(String checkpointId) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.checkpointId.equals(checkpointId))
                return temp.data;
            temp = temp.next;
        }
        return null;
    }

    public double computeTotalDistance() {
        double total = 0;
        Node temp = head;
        while (temp != null) {
            total += temp.data.distanceFromLast;
            temp = temp.next;
        }
        return total;
    }

    public double computeTotalPenalty() {
        double penalty = 0;
        Node temp = head;
        while (temp != null) {
            penalty += temp.data.calculatePenalty();
            temp = temp.next;
        }
        return penalty;
    }

    public boolean checkCriticalConsistency() {
        boolean delivery = false;
        boolean fuel = false;

        Node temp = head;
        while (temp != null) {
            if (temp.data instanceof DeliveryCheckpoint)
                delivery = true;
            if (temp.data instanceof FuelCheckpoint)
                fuel = true;
            temp = temp.next;
        }
        return delivery && fuel;
    }

    public void printRoute() {
        Node temp = head;
        int i = 1;
        while (temp != null) {
            Checkpoint c = temp.data;
            System.out.println( i++ + ". " + c.getType() + " - " + c.locationName + " - " + (c.isDelayed() ? "Delayed" : "On Time") + " - Penalty: " + c.calculatePenalty());
            temp = temp.next;
        }
    }
}
