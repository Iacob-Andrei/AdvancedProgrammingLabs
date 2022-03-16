import com.github.javafaker.Faker;
import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    static List<Street> generateStreets(){

        Faker faker = new Faker();

        List<Street> streets = IntStream.rangeClosed(0, 15)
                .mapToObj(index -> new Street( faker.address().streetName(), (int)(Math.random() * ( 6 - 2 ) + 2) ))
                .toList();

        //List<Street> listOfStreets = new LinkedList<>(streets);
        //listOfStreets.sort( (Street street1, Street street2) -> street1.getLength().compareTo(street2.getLength()) );

        return streets;
    }

    static List<Intersection> generateIntersections(){

        Faker faker = new Faker();

        List<Intersection> intersections = IntStream.rangeClosed(0, 8)
                .mapToObj(index -> new Intersection(faker.address().streetAddressNumber()))
                .toList();

        //Set<Intersection> setOfIntersections = new HashSet<>(intersections);
        //System.out.println(setOfIntersections);

        return intersections;
    }

    public static void main(String[] args) {

        List<Street> streets = generateStreets();
        List<Intersection> intersections = generateIntersections();

        City city = new City(streets, intersections);
        city.query(4);
    }

}
