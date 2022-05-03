package solution;

import entity.ContinentsEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.ContinentRepository;

import static org.junit.jupiter.api.Assertions.*;

class CompulsoryTest {


    @Test
    @DisplayName("Testing to check if ContinentRepository find correct the Europe continent")
    void testFindByName(){

        ContinentsEntity continent = ContinentRepository.findByName("Europe");
        assertEquals("Europe", continent.getName());
    }


    @Test
    @DisplayName("Testing to check if ContinentRepository find correct continent with id:2")
    void testFindById(){

        ContinentsEntity continent = ContinentRepository.findById(2);
        assert continent != null;
        assertEquals("Africa", continent.getName());
    }
}