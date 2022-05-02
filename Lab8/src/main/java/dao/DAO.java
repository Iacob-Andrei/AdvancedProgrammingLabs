package dao;

import model.Table;

import java.sql.SQLException;

public abstract class DAO {

    public abstract Table findById(int id) throws SQLException;
    public abstract Table findByName(String name) throws SQLException;
}
