package imports;

import com.github.javafaker.Faker;
import entity.CitiesEntity;
import repository.CitiesRepo;

public class ImportCities {

    public static void insertCities(){
        Faker faker = new Faker();
        CitiesRepo citiesRepo = new CitiesRepo();

        int id = 1;

        while( id <= 10_000) {
            CitiesEntity newCity = new CitiesEntity();
            newCity.setName(faker.address().city());
            newCity.setId(id);
            newCity.setCountriesByIdCountry(null);
            newCity.setLatitude(0.0);
            newCity.setLongitude(0.0);
            newCity.setCapital(faker.number().numberBetween(0,1));

            //citiesRepo.create(newCity);
            id++;
            System.out.println(newCity.getId() + newCity.getName());
        }
    }
}
