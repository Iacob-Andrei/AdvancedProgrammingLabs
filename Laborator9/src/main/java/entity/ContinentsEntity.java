package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@NamedQuery( name = "Continent.findById", query = "SELECT c FROM ContinentsEntity c WHERE c.id1 = :id")
@NamedQuery( name = "Continent.findByName", query = "SELECT c FROM ContinentsEntity c WHERE c.name = :name")
@Table(name = "continents", schema = "javaDatabase")
public class ContinentsEntity {
    @Id
    @Column(name = "id1")
    private int id1;

    @Basic
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "continentsByIdContinent")
    private Collection<CountriesEntity> countriesById1 = new ArrayList<>();

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContinentsEntity that = (ContinentsEntity) o;

        if (id1 != that.id1) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id1;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<CountriesEntity> getCountriesById1() {
        return countriesById1;
    }

    public void setCountriesById1(Collection<CountriesEntity> countriesById1) {
        this.countriesById1 = countriesById1;
    }
}
