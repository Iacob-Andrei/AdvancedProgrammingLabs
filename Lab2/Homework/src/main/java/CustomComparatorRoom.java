import java.util.Comparator;

public class CustomComparatorRoom implements Comparator<Room> {

    /**
     * Custom comparator used to compare 2 rooms by their capacity
     * @param camera1
     * @param camera2
     * @return result of the comparison
     */
    public int compare(Room camera1, Room camera2){
        return Integer.compare(camera1.getCapacity(), camera2.getCapacity());
    }

}
