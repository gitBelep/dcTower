package dcTower;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ElevatorPool {
    private final List<Elevator> elevators = new ArrayList<>(7);
    private final Queue<Request> requests = new LinkedList<>();

    public ElevatorPool() {
        for (int i = 0; i < 7; i++) {
            elevators.add(new Elevator(i));
        }
    }

    public Elevator getNearestFreeElevatorOrNull() {
        Elevator nearestFreeElevator = null;
        if (requests.isEmpty()) {
            return null;
        }
        int personsStartFloor = requests.peek().getCurrentFloor();
        for (Elevator actual : elevators) {
            if (actual.isFree()) {
                if (nearestFreeElevator == null) {
                    nearestFreeElevator = actual;
                }
                if (Math.abs(actual.getCurrentPos() - personsStartFloor) < Math.abs(nearestFreeElevator.getCurrentPos() - personsStartFloor)) {
                    nearestFreeElevator = actual;
                }
            }
        }
        return nearestFreeElevator;
    }

    public void liftPerson(Elevator elevator) {
        elevator.travel(requests.poll());
    }

    public void addRequest(Request request) {
        requests.offer(request);
    }

    public Queue<Request> getRequests() {
        return new LinkedList<>(requests);
    }

    public List<Elevator> getElevators() {
        return new ArrayList<>(elevators);
    }

}
