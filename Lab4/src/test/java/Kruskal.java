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


    }


}

