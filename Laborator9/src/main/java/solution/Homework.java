package solution;

import entity.*;
import repository.*;
import imports.ImportCities;
import manager.ManagerFactory;


public class Homework {

    public static void main(String[] args) {

        CountriesRepo countriesRepo = new CountriesRepo();
        ContinentsRepo continentsRepo = new ContinentsRepo();

        CountriesEntity romania = countriesRepo.findById(1);
        System.out.println( romania.getName() + " is in " + romania.getContinentsByIdContinent().getName() );

        CountriesEntity italy = new CountriesEntity();
        italy.setId2(2);
        italy.setName("Italy");
        italy.setContinentsByIdContinent(romania.getContinentsByIdContinent());
        //countriesRepo.create(italy);
        System.out.println( countriesRepo.findById(2).getName() );

        System.out.println("In " + romania.getContinentsByIdContinent().getName() + " we have: ");
        for( CountriesEntity entity : romania.getContinentsByIdContinent().getCountriesById1() ){
            System.out.print(entity.getName() + " ");
        }
        System.out.println();

        ImportCities.insertCities();
        ManagerFactory.close();
    }
}
