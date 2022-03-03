import java.util.Comparator;

public class CustomComparatorRoom implements Comparator<Room> {

    /**
     * Custom comparator used to compare 2 rooms by their capacity
     * @param camera1 - first room to be compared
     * @param camera2 - second room to be compared
     * @return result of the comparison
     */
    public int compare(Room camera1, Room camera2){
        return Integer.compare(camera1.getCapacity(), camera2.getCapacity());
    }

}
