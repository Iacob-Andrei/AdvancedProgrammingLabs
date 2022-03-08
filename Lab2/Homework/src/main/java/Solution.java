import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public ArrayList<Room>  roomsSorted;
    public ArrayList<Event> eventsOrdered;

    /**
     * create the array roomsSorted, to store the rooms by their capacity
     * create the array eventsOrdered, to store the events and then sort them by the "start" time
     * @param instance - the instance of the problem
     */
    Solution(Problem instance){

        roomsSorted = new ArrayList<Room>(instance.rooms);
        Collections.sort(roomsSorted, new CustomComparatorRoom());

        eventsOrdered = new ArrayList<Event>(instance.events);
        Collections.sort(eventsOrdered, new CustomComparatorEvent());
    }

    /**
     * toString method
     * @return - returning all the rooms and the events in the problem
     */
    public String toString(){
        StringBuilder stringToReturn = new StringBuilder();

        stringToReturn.append("\nThe rooms are:\n");
        for(Room camera : roomsSorted ){
            stringToReturn.append(camera.toString());
            stringToReturn.append("\n");
        }

        stringToReturn.append("\nThe events are:\n");
        for(Event event : eventsOrdered){
            stringToReturn.append(event.toString());
            stringToReturn.append("\n");
        }

        return stringToReturn.toString();
    }

    /**
     * create the array availability, to store info about rooms
     * if room1 is unused, the value in availability will be -1
     * if room1 is used, the value will be the end time of the event
     *
     * in order to assign a room to an event, we check:
     * assign course only in course halls, and laboratories in labs
     * check if the capacity is met
     * if the room is free
     *
     * if all the conditions are met, then:
     * change the availability of the room
     * assign the event to room
     */
    public void assignRoomToEvent(){

        ArrayList<Integer> availability = new ArrayList<Integer>();
        for( Room number : roomsSorted ){
            availability.add(-1);
        }

        for( Event event : eventsOrdered ){

            int position = 0;
            for( Room room : roomsSorted ){
                if( event.getName().charAt(0) == room.getType().charAt(0) ){
                    if( event.getNumberOfParticipants() <= room.getCapacity() ){
                        if( availability.get( position ) == -1 ){

                            availability.set(position, event.getEnd());
                            System.out.println( event.getName() + " -> " + room.getName() );
                            break;
                        } else if( availability.get(position) <= event.getStart() ){

                            availability.set(position, event.getEnd());
                            System.out.println( event.getName() + " -> " + room.getName() );
                            break;
                        }
                    }
                }
                position++;
            }
        }

    }
}
