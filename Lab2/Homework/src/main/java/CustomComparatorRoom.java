import java.util.Comparator;

public class CustomComparatorRoom implements Comparator<Room> {

    public int compare(Room camera1, Room camera2){
        return Integer.compare(camera1.getCapacity(), camera2.getCapacity());
    }

}
