package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL = "jdbc:mysql://ip-database.ccrihfbatmnt.eu-central-1.rds.amazonaws.com:3306/javaDatabase";
    private static final String USER = "admin";
    private static final String PASSWORD = "6kT4Yi1S7AtqErWTxZyD";
    private static Connection connection = null;

    /**
     * making the constructor private implies that no objects can be created
     */
    private Database(){}

    public static Connection getConnection(){
        return connection;
    }

    /**
     * commit the changes into the db and close the connection with db server
     */
    public static void closeConnection(){
        try {
            connection.commit();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * creating a connection to db server and sets the autocommit to false
     */
    public static void createConnection(){
        try{
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
