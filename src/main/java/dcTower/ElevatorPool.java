package dcTower;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ElevatorPool {
    private final List<Elevator> elevators = new ArrayList<>(7);
    private final Queue<Request> requests = new LinkedList<>();
    //Elem hozzáadása  végére	boolean  offer(E e)
    //Elem kivétele   elejéről	E        poll()
    //Fej lekérdezése	        E        peek()


    public ElevatorPool() {
        for(int i = 0; i < 7; i++){
            elevators.add(new Elevator(i));
        }
    }

    public void findNearestFreeElevatorOrSchedule(Request request){

    }

    public void addRequest(Request request){
        requests.offer(request);
    }

    public Request getRequest(){
        return requests.poll();
    }

}
