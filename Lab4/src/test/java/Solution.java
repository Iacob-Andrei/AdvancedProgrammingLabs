import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {

        List<Intersection>  intersections = IntStream.rangeClosed(0, 3)
                .mapToObj(index -> new Intersection("v" + index))
                .toList();

        List<Street> streets = IntStream.rangeClosed(0, 15)
                .mapToObj(index -> new Street("s" + index, (int)(Math.random() * ( 4 - 1 ) + 1) ))
                .toList();


        List<Street> listOfStreets = new LinkedList<>(streets);

        System.out.println( listOfStreets );
        listOfStreets.sort( (Street street1, Street street2) -> street1.getLength().compareTo(street2.getLength()) );
        System.out.println( listOfStreets );


        Set<Intersection> setOfIntersections = new HashSet<>(intersections);

        System.out.println(setOfIntersections);

        Intersection inter = new Intersection("v0");
        setOfIntersections.add(inter);
        System.out.println(setOfIntersections);
    }
}
