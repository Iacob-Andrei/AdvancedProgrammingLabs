import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class City {

    Map<Intersection, List<Street>> cityMap = new HashMap<>();

    public void addToMap( Intersection intersection, List<Street> list ){
        cityMap.put(intersection, list);
    }
}
