package dao;

import java.sql.SQLException;

public abstract class DAO {

    public abstract String findById(int id) throws SQLException;
    public abstract int findByName(String name) throws SQLException;
}
