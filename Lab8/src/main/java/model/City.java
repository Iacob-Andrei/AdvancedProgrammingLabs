package model;

public class City extends Table{

    private String country;
    private int capital;
    private double latitude;
    private double longitude;

    City(int id, String name, String country, int capital, double longitude, double latitude){
        this.id = id;
        this.name = name;
        this.country = country;
        this.capital = capital;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
