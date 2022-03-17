import java.util.*;

public class City {

    Map<Intersection, List<Street>> cityMap = new HashMap<>();

    City(List<Street> streets, List<Intersection> intersections){
        System.out.println("\n\nThe streets are: " + streets + "\n\n");
        System.out.println("The intersections are: " + intersections + "\n\n");

        addToMap(intersections.get(0), Arrays.asList(streets.get(0),streets.get(1),streets.get(2)));
        addToMap(intersections.get(1), Arrays.asList(streets.get(0),streets.get(6),streets.get(7)));
        addToMap(intersections.get(2), Arrays.asList(streets.get(1),streets.get(3),streets.get(5),streets.get(6),streets.get(11)));
        addToMap(intersections.get(3), Arrays.asList(streets.get(2),streets.get(3),streets.get(4)));
        addToMap(intersections.get(4), Arrays.asList(streets.get(4),streets.get(5),streets.get(8),streets.get(9)));
        addToMap(intersections.get(5), Arrays.asList(streets.get(7),streets.get(8),streets.get(13),streets.get(14)));
        addToMap(intersections.get(6), Arrays.asList(streets.get(10),streets.get(11),streets.get(12)));
        addToMap(intersections.get(7), Arrays.asList(streets.get(9),streets.get(10),streets.get(13),streets.get(15)));
        addToMap(intersections.get(8), Arrays.asList(streets.get(12),streets.get(14),streets.get(15)));
    }

    private void addToMap( Intersection intersection, List<Street> list ){
        cityMap.put(intersection, list);
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();

        for( Intersection intersection : cityMap.keySet() ){

            toString.append(intersection.toString()).append(" intersect: ");
            toString.append( cityMap.get(intersection) );
            toString.append("\n");
        }

        return toString.toString();
    }

    public void query(int length){

        Set<Street> streets = new HashSet<>();
        cityMap.values().forEach(streets::addAll);

        System.out.println("Streets that have length >= " + length + " and intersect more than 3 streets are: \n");

        streets.stream()
                .filter( street -> street.getLength() >= length )
                .filter( street -> cityMap.values().stream().anyMatch(intersect -> intersect.contains(street) && intersect.size() >= 4) )
                .forEach(System.out::println);
    }
}
