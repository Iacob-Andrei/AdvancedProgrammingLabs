package model;

import java.util.StringJoiner;

public class Country extends Table{

    private final String code;
    private final String continent;

    public Country(int id, String name, String code, String continent){
        this.id = id;
        this.name = name;
        this.code = code;
        this.continent = continent;
    }

    public String getCode() {
        return code;
    }

    public String getContinent() {
        return continent;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " is in " + continent + " and has code: " + code;
    }
}
