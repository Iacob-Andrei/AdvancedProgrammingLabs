import java.util.ArrayList;

public class Problem {

    public ArrayList<Room> rooms;
    public ArrayList<Event> events;

    /**
     * constructor
     * initializes the "rooms" and "events" ArrayLists using the "addRooms" and "addEvents" methods
     */
    Problem(){
        addRooms();
        addEvents();
    }

    /**
     * method check if the room was already added
     * if not, room is added to the "rooms" ArrayList
     * @param obj - the room that wants to be added
     */
    private void addToRooms(Room obj){

        for( Room room : rooms ){
            if( room.equals(obj) ){
                System.out.println("Camera " + obj.getName() + " deja exista!");
                return;
            }
        }
        rooms.add(obj);
    }

    /**
     * method check if the event was already added
     * if not, event is added to the "events" ArrayList
     * @param obj - the event that wants to be added
     */
    private void addToEvents(Event obj){

        for( Event event : events ){
            if( event.equals(obj) ){
                System.out.println("Evenimentul " + obj.getName() + " deja exista!");
                return;
            }
        }

        events.add(obj);
    }

    /**
     * method used to add some rooms
     */
    private void addRooms(){

        rooms = new ArrayList<Room>();

        Room room1 = new LabRoom("Windows", "401", 30);
        Room room2 = new LabRoom("Mac OS", "403", 30);
        Room room3 = new LabRoom( "Ubuntu","405", 30);
        Room room4 = new LectureHall(true, "309", 100);

        addToRooms(room1);
        addToRooms(room2);
        addToRooms(room2);
        addToRooms(room3);
        addToRooms(room4);
    }

    /**
     * method used to add some events
     */
    private void addEvents() {

        events = new ArrayList<Event>();

        Event event1 = new Event("C1", 100, 8, 10);
        Event event2 = new Event("C2", 100, 10, 12);
        Event event3 = new Event("L1", 30, 8, 10);
        Event event4 = new Event("L2", 25, 8, 10);
        Event event5 = new Event("L3", 25, 10, 12);

        addToEvents(event1);
        addToEvents(event2);
        addToEvents(event3);
        addToEvents(event4);
        addToEvents(event5);
    }

    /**
     * method used to print all the rooms
     */
    public void printRooms(){

        System.out.println();
        for(Room room : rooms){
            System.out.println(room.toString());
        }
        System.out.println();
    }

    /**
     * method used to print all the events
     */
    public void printEvents(){

        System.out.println();
        for(Event event : events){
            System.out.println(event);
        }
        System.out.println();
    }

}