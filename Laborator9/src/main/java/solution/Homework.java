package solution;

import entity.*;
import repository.*;
import imports.ImportCities;
import manager.ManagerFactory;


public class Homework {

    public static void main(String[] args) {

        ImportCities.insertCities();
        ManagerFactory.close();
    }
}
