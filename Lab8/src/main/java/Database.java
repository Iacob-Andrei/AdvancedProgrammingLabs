import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL = "jdbc:mysql://ip-database.ccrihfbatmnt.eu-central-1.rds.amazonaws.com:3306/javaDatabase";
    private static final String USER = "admin";
    private static final String PASSWORD = "6kT4Yi1S7AtqErWTxZyD";
    private static Connection connection = null;

    public static Connection getConnection(){
        return connection;
    }

    public static void closeConnection(){
        try {
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void createConnection(){
        try{
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
