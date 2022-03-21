import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.File;
import java.io.IOException;
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

    public void save() throws IOException {

        File file = new File("target/catalog.json");
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(file, catalog);
    }

    public void load(){

    }
}
