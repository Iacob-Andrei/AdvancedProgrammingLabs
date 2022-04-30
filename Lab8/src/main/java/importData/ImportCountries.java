package importData;

import database.Database;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class ImportCountries {

    static public void importData() throws IOException {

            BufferedReader lineReader = new BufferedReader(new FileReader("E:\\Codes\\AdvancedProgrammingLabs\\Lab8\\src\\main\\resources\\concap.csv"));
            String lineText = null;

            lineReader.readLine(); // skip header line

            while ((lineText = lineReader.readLine()) != null) {

                List<String> data = Arrays.stream(lineText.split(",")).toList();
                System.out.println( data );
            }

    }
}
