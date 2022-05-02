package importData;

import dao.CityDAO;
import dao.ContinentDAO;
import dao.CountryDAO;
import database.Database;
import model.City;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class ImportCountries {

    /**
     * opens the csv file, parse it line by line and add data into cities and countries tables
     * @throws IOException
     */
    static public void importData() throws IOException {

            BufferedReader lineReader = new BufferedReader(new FileReader("E:\\Codes\\AdvancedProgrammingLabs\\Lab8\\src\\main\\resources\\concap.csv"));
            String lineText = null;

            lineReader.readLine(); // skip header

            while ((lineText = lineReader.readLine()) != null) {

                List<String> data = Arrays.stream(lineText.split(",")).toList();

                String country = data.get(0);
                String city = data.get(1);
                double latitude = Double.parseDouble(data.get(2));
                double longitude = Double.parseDouble(data.get(3));
                String code = data.get(4);
                String continent = data.get(5);

                CountryDAO.create(country, code, continent);
                CityDAO.create(country, city, 1, latitude, longitude);
            }
    }
}
