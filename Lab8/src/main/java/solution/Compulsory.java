package solution;

import dao.ContinentDAO;
import dao.CountryDAO;
import database.Database;

public class Compulsory {

    public static void main(String[] args) {

        try {

            CountryDAO countryDAO = new CountryDAO();
            ContinentDAO continentDAO = new ContinentDAO();

            Database.createConnection();

            ContinentDAO.create("Europe");

            //System.out.println("ID for Europe is: " + ContinentDAO.findByName("Europe"));
            //System.out.println("Continent with ID = 1 is: " + ContinentDAO.findById(1));

            CountryDAO.create("Romania", "40", continentDAO.findByName("Europe") );
            CountryDAO.create("Ukraine", "380", continentDAO.findByName("Europe") );
            CountryDAO.create("Italy", "39", continentDAO.findByName("Europe") );

            ContinentDAO.countriesInContinent( continentDAO.findByName("Europe") );

            Database.closeConnection();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
