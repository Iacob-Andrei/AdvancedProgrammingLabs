import java.util.Comparator;

public class CustomComparatorEvent implements Comparator<Event> {

    /**
     * Custom comparator used to compare 2 events by their start time
     * @param event1
     * @param event2
     * @return result of the comparison
     */
    public int compare(Event event1, Event event2){
        return Integer.compare(event1.getStart(), event2.getStart());
    }

}
