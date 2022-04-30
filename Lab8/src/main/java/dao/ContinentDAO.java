package dao;

import database.Database;
import java.sql.*;

public class ContinentDAO extends DAO{

    /**
     * insert a row into the 'continents' table
     * @param name of the continent
     */
    static public void create(String name){

        try {
            Connection conn = Database.getConnection();
            PreparedStatement statement = conn.prepareStatement("INSERT INTO continents VALUES(?,?)");

            int id = 1 + getMaxId();
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * @return the current max id from continents table
     */
    static private int getMaxId() throws SQLException {

        Connection conn = Database.getConnection();
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("SELECT MAX(id) FROM continents");

        return result.next() ? result.getInt(1) : 0;
    }

    /**
     * @param name for query
     * @return select the id of the continent that has the specified name
     */
    public int findByName(String name) throws SQLException {

        Connection conn = Database.getConnection();
        Statement statement = conn.createStatement();

        ResultSet result = statement.executeQuery("SELECT id FROM continents WHERE name = '" + name + "'");

        return result.next() ? result.getInt(1) : -1;
    }

    /**
     * @param id for query
     * @return select the name of the continent that has the specified id
     */
    public String findById(int id) throws SQLException {

        Connection conn = Database.getConnection();
        Statement statement = conn.createStatement();

        ResultSet result = statement.executeQuery("SELECT name FROM continents WHERE id = " + id);

        return result.next() ? result.getString(1) : null;
    }

    /**
     * prints all the countries from countries table that are in the specified continent
     * @param id of the continent
     */
    static public void countriesInContinent(int id) throws SQLException {

        Connection conn = Database.getConnection();
        Statement statement = conn.createStatement();

        ResultSet result = statement.executeQuery("SELECT * FROM countries WHERE continent = " + id);

        System.out.println("Countries in Europe:");
        while( result.next() ){
            String name = result.getString("name");
            String code = result.getString("code");
            System.out.println(name + " has code " + code);
        }
    }
}
