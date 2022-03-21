package algorithm;
import graph.*;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import java.util.*;

public class Kruskal {

    List<Intersection> nodes = new ArrayList<>();
    Set<Street> vertexes = new HashSet<>();
    Map<Intersection, List<Street>> cityMap;

    public Kruskal(Map<Intersection, List<Street>> cityMap){

        this.cityMap = cityMap;
        cityMap.values().forEach(vertexes::addAll);
        nodes.addAll(cityMap.keySet());
    }

    /**
     * @param oldRoot .
     * @param newRoot new root for nodes that contains the old root
     * @param root hashMap which contains the root of every node, from their specific subtree
     * @return the updated root hashMap
     */
    public Map<Intersection, Intersection> union(Intersection oldRoot, Intersection newRoot, Map<Intersection, Intersection> root){

        for( Intersection intersection : root.keySet() )
            if( root.get(intersection).equals(oldRoot) ) {
                root.put(intersection, newRoot);
            }

        return root;
    }

    /**
     * using the algorithm.Kruskal algorithm, compute the MST in the city using the cityMap
     *
     * order the vertexes by their length
     * select every vertex, then checking if the added vertex create a cycle in the graph
     * if not, keep the vertex
     */
    public void MST(){

        List<Street> orderedVertexes = new LinkedList<>(vertexes);
        orderedVertexes.sort( (Street street1, Street street2) -> Integer.compare(street1.getLength(), street2.getLength() ) );

        Map<Intersection, Intersection> root = new HashMap<>();
        for( Intersection intersection : nodes )
            root.put(intersection, intersection);

        int totalCost = 0;
        System.out.println("Selected vertexes for MST: ");

        for( Street street : orderedVertexes ){

            Pair<Intersection, Intersection> pair = getNodes(street);
            Intersection intersectionOne = pair.getLeft();
            Intersection intersectionTwo = pair.getRight();

            if( !root.get(intersectionOne).equals( root.get(intersectionTwo) ) ){
                root = union(root.get(intersectionOne), root.get(intersectionTwo), root);
                System.out.print( street.getName() + "("+ street.getLength() +") -> " );
                totalCost += street.getLength();
            }
        }

        System.out.println("Total cost is: " + totalCost );
    }

    /**
     * @param street .
     * @return a pair representing the two adjacent vertexes that are connected with the "graph.Street" given as parameter
     */
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

