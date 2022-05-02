package model;

public class City extends Table{

    private final String country;
    private final int capital;
    private final double latitude;
    private final double longitude;

    public City(int id, String name, String country, int capital, double longitude, double latitude){
        this.id = id;
        this.name = name;
        this.country = country;
        this.capital = capital;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * @param city destination
     * @return the distance between the two cities
     */
    public double distance(City city){

        // The math module contains a function
        // named toRadians which converts from
        // degrees to radians.
        double lon1 = Math.toRadians(longitude);
        double lat1 = Math.toRadians(latitude);
        double lon2 = Math.toRadians(city.getLongitude());
        double lat2 = Math.toRadians(city.getLatitude());

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;

        // calculate the result
        return(c * r);
    }

    public String getCountry() {
        return country;
    }

    public int getCapital() {
        return capital;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
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
        return name + " is in " + country + ", capital = " + capital + ", has coordinates: latitude = " + latitude + ", longitude = " + longitude;
    }
}
