import java.util.ArrayList;

public class Main {

    public static ArrayList<Room> addRooms(){

        ArrayList<Room> rooms = new ArrayList<Room>();

        Room room1 = new Room(Type.LABORATORY, "401", 30);
        Room room2 = new Room(Type.LABORATORY, "403", 30);
        Room room3 = new Room(Type.LABORATORY, "405", 25);
        Room room4 = new Room(Type.COURSE, "405", 100);

        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);

        return rooms;
    }

    public static ArrayList<Event> addEvents() {

        ArrayList<Event> events = new ArrayList<Event>();

        Event event1 = new Event("C1", 100, 8, 10, Type.COURSE);
        Event event2 = new Event("C2", 100, 10, 12, Type.COURSE);
        Event event3 = new Event("L1", 30, 8, 10, Type.LABORATORY);
        Event event4 = new Event("L2", 25, 10, 12, Type.LABORATORY);
        Event event5 = new Event("L3", 25, 10, 12, Type.LABORATORY);

        events.add(event1);
        events.add(event2);
        events.add(event3);
        events.add(event4);
        events.add(event5);

        return events;
    }

    public static void main(String[] args) {

        ArrayList<Room> rooms = addRooms();
        for( Room room : rooms ){
            System.out.println(room.toString());
        }

        System.out.println();

        ArrayList<Event> events = addEvents();
        for( Event event : events ){
            System.out.println(event.toString());
        }
    }
}
