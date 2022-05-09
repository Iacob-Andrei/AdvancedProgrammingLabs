package imports;

import com.github.javafaker.Faker;
import entity.CitiesEntity;
import manager.ManagerFactory;
import repository.CitiesRepo;

import javax.persistence.EntityManager;


public class ImportCities {

    /**
     * create a large number of CitiesEntity in order to check the log execution time of JPQL queries
     */
    public static void insertCities(){

        long startTime = System.nanoTime();

        EntityManager em = ManagerFactory.getEntityManager().createEntityManager();
        em.getTransaction().begin();

        Faker faker = new Faker();
        CitiesRepo citiesRepo = new CitiesRepo();

        int id = 1;

        while( id <= 1_000) {
            CitiesEntity newCity = new CitiesEntity();
            newCity.setName(faker.address().city());
            newCity.setId(id);
            newCity.setCountriesByIdCountry(null);
            newCity.setLatitude(0.0);
            newCity.setLongitude(0.0);
            newCity.setCapital(faker.number().numberBetween(0,1));

            citiesRepo.create(newCity);
            id++;
            System.out.println(id);
        }

        long endTime = System.nanoTime();
        System.out.println( (endTime - startTime) / 1_000_000 / 1_000 / 60  );
        em.getTransaction().commit();
    }
}
