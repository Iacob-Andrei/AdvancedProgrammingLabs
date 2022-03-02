import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public ArrayList<Room> lectureHallsOrdered;
    public ArrayList<Room> labRoomsOrdered;
    public ArrayList<Event> eventsOrdered;

    Solution(Problem instance){

        // create the array lectureHallsOrdered, to store ONLY the available lecture halls
        // create the array labRoomsOrdered, to store ONLY the available course halls

        lectureHallsOrdered = new ArrayList<Room>();
        labRoomsOrdered     = new ArrayList<Room>();

        for(Room camera : instance.rooms){
            if( camera.type.equals("lecture hall")){
                lectureHallsOrdered.add(camera);
            }
            else{
                labRoomsOrdered.add(camera);
            }
        }

        // sort the two arrays using the custom comparator, sorting by the capacity of the rooms
        Collections.sort(lectureHallsOrdered, new CustomComparatorRoom());
        Collections.sort(labRoomsOrdered, new CustomComparatorRoom());


        // create the array eventsOrdered, to store the events and then sort them by the "start" time
        eventsOrdered = new ArrayList<Event>(instance.events);
        Collections.sort(eventsOrdered, new CustomComparatorEvent());
    }

    public String toString(){
        StringBuilder stringToReturn = new StringBuilder();

        stringToReturn.append("\nThe lecture halls are:\n");
        for(Room camera : lectureHallsOrdered ){
            stringToReturn.append(camera.toString());
            stringToReturn.append("\n");
        }

        stringToReturn.append("\nThe lab rooms are:\n");
        for(Room camera : labRoomsOrdered ){
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

    public static void main(String[] args) {

        Problem myProblem = new Problem();
        Solution solution = new Solution(myProblem);

        System.out.println(solution);
    }
}
