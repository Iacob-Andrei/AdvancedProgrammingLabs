package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@NamedQuery( name = "Countries.findById", query = "SELECT c FROM CountriesEntity c WHERE c.id2 = :id")
@NamedQuery( name = "Countries.findByName", query = "SELECT c FROM CountriesEntity c WHERE c.name = :name")
@Table(name = "countries", schema = "javaDatabase")
public class CountriesEntity {
    @Id
    @Column(name = "id2")
    private int id2;

    @Basic
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "countriesByIdCountry")
    private Collection<CitiesEntity> citiesById2 = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "idContinent", referencedColumnName = "id1")
    private ContinentsEntity continentsByIdContinent;

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
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

        CountriesEntity that = (CountriesEntity) o;

        if (id2 != that.id2) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id2;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<CitiesEntity> getCitiesById2() {
        return citiesById2;
    }

    public void setCitiesById2(Collection<CitiesEntity> citiesById2) {
        this.citiesById2 = citiesById2;
    }

    public ContinentsEntity getContinentsByIdContinent() {
        return continentsByIdContinent;
    }

    public void setContinentsByIdContinent(ContinentsEntity continentsByIdContinent) {
        this.continentsByIdContinent = continentsByIdContinent;
    }
}
