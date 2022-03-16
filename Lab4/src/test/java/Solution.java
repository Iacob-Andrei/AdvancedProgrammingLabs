import com.github.javafaker.Faker;
import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    static List<Street> generateStreets(){

        Faker faker = new Faker();

        List<Street> streets = IntStream.rangeClosed(0, 18)
                .mapToObj(index -> new Street(faker.address().streetName(), (int)(Math.random() * ( 6 - 2 ) + 2) ))
                .toList();


        List<Street> listOfStreets = new LinkedList<>(streets);
        listOfStreets.sort( (Street street1, Street street2) -> street1.getLength().compareTo(street2.getLength()) );

        return listOfStreets;
    }

    static List<Intersection> generateIntersections(){

        Faker faker = new Faker();

        List<Intersection> intersections = IntStream.rangeClosed(0, 8)
                .mapToObj(index -> new Intersection("v" + index))
                .toList();

        Set<Intersection> setOfIntersections = new HashSet<>(intersections);
        //System.out.println(setOfIntersections);

        return intersections;
    }

    static void assignIntersectionToStreet(List<Street> streets, List<Intersection> intersections, City city){

        System.out.println("The streets are: " + streets + "\n\n");
        System.out.println("The intersections are: " + intersections + "\n\n");

        for( Street street : streets ){

            int indexStreetOne = (int)(Math.random() * (9 - 1 ) - 1);
            int indexStreetTwo = (int)(Math.random() * (9 - 1 ) - 1);

            System.out.println("For street " + street.getName() + " we have intersections: " + intersections.get(indexStreetOne) + " and " + intersections.get(indexStreetTwo));
        }

    }

    public static void main(String[] args) {

        List<Street> streets = generateStreets();
        List<Intersection> intersections = generateIntersections();

        City city = new City();
        assignIntersectionToStreet(streets, intersections, city);
    }

}
