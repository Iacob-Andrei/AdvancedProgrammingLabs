import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public ArrayList<Room>  roomsSorted;
    public ArrayList<Event> eventsOrdered;

    Solution(Problem instance){

        // create the array roomsSorted, to store the rooms by their capacity
        roomsSorted = new ArrayList<Room>(instance.rooms);
        Collections.sort(roomsSorted, new CustomComparatorRoom());

        // create the array eventsOrdered, to store the events and then sort them by the "start" time
        eventsOrdered = new ArrayList<Event>(instance.events);
        Collections.sort(eventsOrdered, new CustomComparatorEvent());
    }

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

    public void assignRoomToEvent(){

        // create the array availability, to store info about rooms
        // if room1 is unused, the value in availability will be -1
        // if room1 is used, the value will be the end time of the event

        ArrayList<Integer> availability = new ArrayList<Integer>();
        for( Room number : roomsSorted ){
            availability.add(-1);
        }

        for( Event event : eventsOrdered ){

            int position = 0;
            for( Room room : roomsSorted ){
                if( event.getName().charAt(0) == room.getType().charAt(0) ){        // assign course only in course halls, and laboratories in labs
                    if( event.getNumberOfParticipants() <= room.getCapacity() ){    // check if the capacity is met
                        if( availability.get( position ) == -1 ){                   // if the room is free

                            availability.set(position, event.getEnd());                         // change the availability of the room
                            System.out.println( event.getName() + " -> " + room.getName() );    // assign the event to room
                            break;
                        } else if( availability.get(position) <= event.getStart() ){

                            availability.set(position, event.getEnd());                          // change the availability of the room
                            System.out.println( event.getName() + " -> " + room.getName() );     // assign the event to room
                            break;
                        }
                    }
                }
                position++;
            }
        }

    }

    public static void main(String[] args) {

        Problem myProblem = new Problem();
        Solution solution = new Solution(myProblem);

        solution.assignRoomToEvent();
    }
}
