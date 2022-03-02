import java.util.Comparator;

public class CustomComparatorEvent implements Comparator<Event> {

    public int compare(Event event1, Event event2){
        return Integer.compare(event1.getStart(), event2.getStart());
    }

}
