import java.util.ArrayList;

public class Problem {

    public static ArrayList<Room> rooms;
    public static ArrayList<Event> events;

    public static void addToRooms(Room obj){

        for( Room room : rooms ){
            if( room.equals(obj) ){
                System.out.println("Camera " + obj.getName() + " deja exista!");
                return;
            }
        }
        rooms.add(obj);
    }

    public static void addRooms(){

        rooms = new ArrayList<Room>();

        Room room1 = new LabRoom("Windows", "401", 30);
        Room room2 = new LabRoom("Mac OS", "403", 30);
        Room room3 = new LabRoom( "Ubuntu","405", 30 );
        Room room4 = new LectureHall(true, "309", 100);

        addToRooms(room1);
        addToRooms(room2);
        addToRooms(room2);
        addToRooms(room3);
        addToRooms(room4);
    }

    public static void addEvents() {

        events = new ArrayList<Event>();

        Event event1 = new Event("C1", 100, 8, 10);
        Event event2 = new Event("C2", 100, 10, 12);
        Event event3 = new Event("L1", 30, 8, 10);
        Event event4 = new Event("L2", 25, 10, 12);
        Event event5 = new Event("L3", 25, 10, 12);

        events.add(event1);
        events.add(event2);
        events.add(event3);
        events.add(event4);
        events.add(event5);
    }

    public static void main(String[] args) {

        addRooms();
        for( Room room : rooms ){
            System.out.println(room.toString());
        }

        System.out.println();

        /*
        addEvents();
        for( Event event : events ){
            System.out.println(event.toString());
        }
         */
    }
}