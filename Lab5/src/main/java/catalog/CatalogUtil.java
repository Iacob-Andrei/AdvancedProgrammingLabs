package catalog;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class CatalogUtil {

    /**
     * saves an object of type catalog into a JSON file
     * @param catalog input catalog object
     * @param path file path
     * @throws IOException exception
     */
    public static void save(Catalog catalog, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path),catalog);
    }

    /**
     * gets info from JSON file into an object of Catalog
     * @param path file path
     * @return Catalog obj
     * @throws IOException exception
     */
    public static Catalog load(String path) throws IOException {

        Catalog catalog = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            catalog = objectMapper.readValue(new File(path), Catalog.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return catalog;
    }
}
