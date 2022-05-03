package solution;

import entity.ContinentsEntity;
import manager.ManagerFactory;
import repository.ContinentRepository;

public class Compulsory {

    public static void main(String[] args) {

        ContinentRepository.create(11, "Oceania");

        ContinentsEntity continent1 = ContinentRepository.findById(1);
        assert continent1 != null;
        System.out.println(continent1.getName());

        ContinentsEntity continent2 = ContinentRepository.findByName("Asia");
        System.out.println(continent2.getName());

        ManagerFactory.close();
    }
}
