package dcTower;

public class Elevator {
    private final int id;
    private boolean free = true;
    private int currentPos = 0;
    private Request request;

    public Elevator(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

}
