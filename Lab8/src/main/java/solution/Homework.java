package solution;

import dao.*;
import database.Database;
import importData.ImportCountries;
import model.*;

import java.io.IOException;
import java.sql.SQLException;

public class Homework {

    public static void main(String[] args) throws IOException, SQLException {

        CountryDAO countryDAO = new CountryDAO();
        CityDAO cityDAO = new CityDAO();

        Database.createConnection();

        //ImportCountries.importData();

        Country country = countryDAO.findByName("Romania");
        System.out.println(country);

        City paris = cityDAO.findByName("Paris");
        City rome = cityDAO.findByName("Rome");

        System.out.println(paris + "\n" + rome);
        System.out.println("Distance between Paris and Rome is " + paris.distance(rome) + " km");

        Database.closeConnection();
    }

}
