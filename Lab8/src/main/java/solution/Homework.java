package solution;

import database.Database;
import importData.ImportCountries;

import java.io.IOException;

public class Homework {

    public static void main(String[] args) throws IOException {

        Database.createConnection();

        ImportCountries.importData();

        Database.closeConnection();
    }

}
