import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    public static <Hash> void main(String[] args) {

        var intersections = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Intersection("v" + i))
                .toArray(Intersection[]::new);

        var streets = IntStream.rangeClosed(0, 15)
                .mapToObj(i -> new Street("s" + i, (int)(Math.random() * ( 4 - 1 ) + 1) ))
                .toArray(Street[]::new);

        List<Street> listOfStreets = new LinkedList<>();
        Collections.addAll(listOfStreets, streets);

        System.out.println( listOfStreets );
        listOfStreets.sort( (u, v) -> u.getLength().compareTo(v.getLength()) );
        System.out.println( listOfStreets );

        Set<Intersection> setOfIntersections = new HashSet<>();
        Collections.addAll(setOfIntersections, intersections);
        System.out.println(setOfIntersections);

        Intersection inter = new Intersection("v0");
        setOfIntersections.add(inter);
        System.out.println(setOfIntersections);
    }
}
