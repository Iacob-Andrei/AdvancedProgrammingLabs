package repo;

import database.Database;
import entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    public void insert(String name,String surname, int age, String nationality) {
        Connection conn = Database.getConnection();
        try {
            String query = "INSERT INTO people(name,surname,age,nationality) VALUES(?,?,?,?)";

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, nationality);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalStateException("Error in executing the insert query!", e);
        }
    }

    public List<Person> getPeople() {
        Connection conn = Database.getConnection();
        try {
            List<Person> persons = new ArrayList<>();

            String query = "SELECT * from people";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                Person person = new Person(result.getString(2), result.getInt(1));
                persons.add(person);
            }
            return persons;
        } catch (SQLException e) {
            throw new IllegalStateException("Error in executing get request!", e);
        }
    }
}
