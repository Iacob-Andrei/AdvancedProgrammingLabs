package model;

public class Country extends Table{

    private String code;
    private String continent;

    Country(int id, String name, String code, String continent){
        this.id = id;
        this.name = name;
        this.code = code;
        this.continent = continent;
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
