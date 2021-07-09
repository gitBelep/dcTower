package dcTower;

import java.time.LocalDateTime;

public class Elevator {
    static final int TIME_PER_FLOOR = 1000;
    private final int id;
    private int currentPos;
    private LocalDateTime busyTill;

    public Elevator(int id) {
        this.id = id;
        currentPos = 0;
        busyTill = LocalDateTime.now();
    }


    public int getId() {
        return id;
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }

    public boolean isFree() {
        return LocalDateTime.now().isAfter(this.busyTill);
    }

    public void setBusyTill(LocalDateTime busyTill) {
        this.busyTill = busyTill;
    }

    public void travel(Request request) {
        int floorsEmpty = Math.abs(this.getCurrentPos() - request.getCurrentFloor());
        int floorsWithPerson = Math.abs(request.getCurrentFloor() - request.getDestinationFloor());
        int floors = floorsEmpty + floorsWithPerson;
        setBusyTill(LocalDateTime.now().plusSeconds(floors * (TIME_PER_FLOOR / 1000)));
        setCurrentPos(request.getDestinationFloor());
    }

}
