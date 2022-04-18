package dao;

import database.Database;
import java.sql.*;

public class ContinentDAO {

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

    static private int getMaxId() throws SQLException {

        Connection conn = Database.getConnection();
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("SELECT MAX(id) FROM continents");

        return result.next() ? result.getInt(1) : 0;
    }

    static public int findByName(String name) throws SQLException {

        Connection conn = Database.getConnection();
        Statement statement = conn.createStatement();

        ResultSet result = statement.executeQuery("SELECT id FROM continents WHERE name = '" + name + "'");

        return result.next() ? result.getInt(1) : -1;
    }

    static public String findById(int id) throws SQLException {

        Connection conn = Database.getConnection();
        Statement statement = conn.createStatement();

        ResultSet result = statement.executeQuery("SELECT name FROM continents WHERE id = " + id);

        return result.next() ? result.getString(1) : null;
    }
}
