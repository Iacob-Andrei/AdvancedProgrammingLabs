package dao;

import database.Database;
import java.sql.*;

public class CountryDAO {

    /**
     * insert a row into the 'country' table
     * @param name of the country
     */
    static public void create(String name, String code, int continent){

        Connection conn = Database.getConnection();
        try{

            PreparedStatement statement = conn.prepareStatement("INSERT INTO countries VALUES(?,?,?,?)");

            int id = 1 + getMaxId();
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, code);
            statement.setInt(4, continent);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * @return the current max id from country table
     */
    static private int getMaxId() throws SQLException {

        Connection conn = Database.getConnection();
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("SELECT MAX(id) FROM countries");

        return result.next() ? result.getInt(1) : 0;
    }

    /**
     * @param name for query
     * @return select the id of the country that has the specified name
     */
    static public int findByName(String name) throws SQLException {

        Connection conn = Database.getConnection();
        Statement statement = conn.createStatement();

        ResultSet result = statement.executeQuery("SELECT id FROM countries WHERE name = '" + name + "'");

        return result.next() ? result.getInt(1) : -1;
    }

    /**
     * @param id for query
     * @return select the name of the country that has the specified id
     */
    static public String findById(int id) throws SQLException {

        Connection conn = Database.getConnection();
        Statement statement = conn.createStatement();

        ResultSet result = statement.executeQuery("SELECT name FROM countries WHERE id = " + id);

        return result.next() ? result.getString(1) : null;
    }
}
