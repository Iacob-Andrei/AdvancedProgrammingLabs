import java.util.ArrayList;
import java.util.List;

public class Catalog {

    String name;
    List<Item> catalog = new ArrayList<>();

    Catalog(String name){
        this.name = name;
    }

    public void add(Item item) {
        catalog.add(item);
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();

       for(Item item : catalog)
           sb.append(item.toString()).append("\n");

       return sb.toString();
    }

    public void save(){

    }
}
