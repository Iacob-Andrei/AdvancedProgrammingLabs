import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import java.util.*;

public class Kruskal {

    List<Intersection> nodes = new ArrayList<>();
    Set<Street> vertexes = new HashSet<>();
    Map<Intersection, List<Street>> cityMap;

    Kruskal(Map<Intersection, List<Street>> cityMap){

        this.cityMap = cityMap;
        cityMap.values().forEach(vertexes::addAll);
        nodes.addAll(cityMap.keySet());
    }

    public void MST(){

        List<Street> orderedVertexes = new LinkedList<>(vertexes);
        orderedVertexes.sort( (Street street1, Street street2) -> Integer.compare(street1.getLength(), street2.getLength() ) );

        Set<Intersection> selectedNodes = new HashSet<>();
        List<Street> selectedVertexes = new LinkedList<>();

        for( Street street : orderedVertexes ){

            Pair<Intersection, Intersection> pair = getNodes(street);
            Intersection intersectionOne = pair.getLeft();
            Intersection intersectionTwo = pair.getRight();

            if( !selectedNodes.contains(intersectionOne) || !selectedNodes.contains(intersectionTwo) ){
                selectedNodes.add(intersectionOne);
                selectedNodes.add(intersectionTwo);
                selectedVertexes.add(street);
            }
        }

        int totalCost = 0;
        System.out.println("Selected vertexes for MST: ");
        for( Street street : selectedVertexes ){
            System.out.print( street.getName() + "("+ street.getLength() +") -> " );
            totalCost += street.getLength();
        }
        System.out.println("Total cost is: " + totalCost );

    }

    private Pair<Intersection, Intersection> getNodes(Street street){

        Intersection intersectionOne = null;
        Intersection intersectionTwo = null;

        for( Intersection intersection : cityMap.keySet() ) {

            List<Street> list = cityMap.get(intersection);
            if (list.contains(street))
                if (intersectionOne == null) {
                    intersectionOne = intersection;
                } else {
                    intersectionTwo = intersection;
                    break;
                }
        }

        return new ImmutablePair<>(intersectionOne, intersectionTwo);
    }

}

