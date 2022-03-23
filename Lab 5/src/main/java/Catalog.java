import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class Catalog {


    private String name;
    private List<Item> catalog;

    Catalog(String name){
        this.name = name;
        catalog = new ArrayList<>();
    }

    Catalog(){
        catalog = new ArrayList<>();
    }

    public void add(Item item) {
        catalog.add(item);
    }

    public List<Item> getCatalog() {
        return catalog;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("\nCatalog name is: ");
        sb.append(this.getName()).append("\n");

        for( Item item : catalog) {
            String json = "";
            try {
                json = new ObjectMapper().writeValueAsString(item);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            sb.append(json).append(" \n");
        }

        return sb.toString();
    }
}
