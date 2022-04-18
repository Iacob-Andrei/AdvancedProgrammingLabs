package solution;

import dao.ContinentDAO;
import database.Database;

public class Compulsory {

    public static void main(String[] args) {

        try {
            Database.createConnection();

            ContinentDAO.create("Europe");

            System.out.println("ID for Europe is: " + ContinentDAO.findByName("Europe"));
            System.out.println("Continent with ID = 1 is: " + ContinentDAO.findById(1));

            Database.closeConnection();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
