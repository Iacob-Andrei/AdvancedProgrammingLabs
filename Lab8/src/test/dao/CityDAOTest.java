package dao;

import database.Database;
import model.City;
import model.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;


class CityDAOTest {

    @BeforeEach
    void setup(){
        Database.createConnection();
    }

    @Test
    @DisplayName("Testing to check if Paris is capital.")
    void testParisCapital() throws SQLException {

        CityDAO cityDAO = new CityDAO();
        City city = cityDAO.findByName("Paris");

        assertEquals(1, city.getCapital(), "Paris isn't capital.");
    }

    @Test
    @DisplayName("Testing to check if Romania is in database.")
    void testRomania() throws SQLException {

        CountryDAO countryDAO = new CountryDAO();
        Country country = countryDAO.findByName("Romania");

        assertNotEquals( null, country, "Romania is not in database.");
    }

    @Test
    @DisplayName("Checking if China is in Central America.")
    void testChina() throws SQLException{

        CountryDAO countryDAO = new CountryDAO();
        Country country = countryDAO.findByName("China");

        assertEquals( "Central America", country.getContinent(), "China is not in Central America.");
    }
}