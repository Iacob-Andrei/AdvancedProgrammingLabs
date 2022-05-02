package dao;

import database.Database;
import model.City;
import model.Table;

import java.sql.*;

public class CityDAO extends DAO{

    /**
     * insert a row into 'cities' table
     * @param country in which the city is located
     * @param name of the city
     * @param capital 0/1, if it is capital or not
     * @param latitude coordinate
     * @param longitude coordinate
     */
    static public void create(String country, String name, int capital, double latitude, double longitude){

        try {
            Connection conn = Database.getConnection();
            PreparedStatement statement = conn.prepareStatement("INSERT INTO cities(country, name, capital, latitude, longitude) VALUES(?, ?, ?, ?, ?);");

            statement.setString(1, country);
            statement.setString(2, name);
            statement.setInt(3, capital);
            statement.setDouble(4, latitude);
            statement.setDouble(5, longitude);
            statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    /**
     * @param name for query
     * @return select the id of the country that has the specified name
     */
    @Override
    public City findByName(String name) throws SQLException {

        Connection conn = Database.getConnection();
        Statement statement = conn.createStatement();

        ResultSet result = statement.executeQuery("SELECT * FROM cities WHERE name = '" + name + "'");

        return result.next() ? new City(result.getInt("id"), result.getString("name"), result.getString("country"), result.getInt("capital"), result.getDouble("latitude"), result.getDouble("longitude")) : null;
    }

    /**
     * @param id for query
     * @return select the name of the country that has the specified id
     */
    @Override
    public City findById(int id) throws SQLException {

        Connection conn = Database.getConnection();
        Statement statement = conn.createStatement();

        ResultSet result = statement.executeQuery("SELECT * FROM cities WHERE id = " + id);

        return result.next() ? new City(result.getInt("id"), result.getString("name"), result.getString("country"), result.getInt("capital"), result.getDouble("latitude"), result.getDouble("longitude")) : null;
    }
}
