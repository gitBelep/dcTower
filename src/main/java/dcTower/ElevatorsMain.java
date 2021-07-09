package dcTower;

import java.util.List;
import java.util.Scanner;

public class ElevatorsMain{
    private static List<Request> requestList = List.of(
            new Request(0, 14),
            new Request(0, 6),
            new Request(0, 40),
            new Request(0, 15),
            new Request(20, 0),
            new Request(21, 0),
            new Request(0, 16),
            new Request(0, 30),
            new Request(0, 17),
            new Request(14, 0),
            new Request(6, 0),
            new Request(0, 16),
            new Request(0, 30),
            new Request(0, 17),
            new Request(0, 41),
            new Request(0, 15),
            new Request(0, 13),
            new Request(0, 40),
            new Request(0, 2),
            new Request(13, 0),
            new Request(40, 0));

    public static void main(String[] args) throws InterruptedException {
        System.out.println("To Stop the elevators in DC Tower press \"Q\"!");
        int i = 0;
        Scanner sc = new Scanner(System.in);
        String inkey = sc.nextLine().trim().toUpperCase();
        ElevatorPool pool = new ElevatorPool();

        while (!"Q".equals(inkey)) {
            if (pool.getRequests().size() > 0) {
                Elevator nearestElevator = pool.getFreeElevatorOrNull();
                if (nearestElevator != null) {
                    pool.liftPerson(nearestElevator);
                } else {
                    System.out.println("sleep " + pool.getRequests().size() +"requests are waiting");
                    Thread.sleep(Elevator.TIME_PER_FLOOR);
                }
            }
            if(i < requestList.size()) {
                pool.addRequest(requestList.get(i));
                i++;
            }
        }
        sc.close();
        System.out.println("Good Bye!");
    }

}
