package controller;

import entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {
    /*private  List<People> people = PeopleRepo.findAll();
    public PersonController() {
    }
    @GetMapping
    public List<People> getPeople() {
       return people;
    }
    @GetMapping("/count")
    public int countProducts() {
        return people.size();
    }
    @GetMapping("/{id}")
    public People getPerson(@PathVariable("id") int id) {
        return people.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
    }*/

    private final List<Person> people = new ArrayList<>();
    public PersonController() {
        people.add(new Person(1,"Raluca","Munteanu",21,"romanian"));
        people.add(new Person(2,"Andrei","Iacob",20,"romanian"));
    }
    @GetMapping
    public List<Person> getPeople() {
        return people;
    }
    @GetMapping("/count")
    public int countProducts() {
        return people.size();
    }
    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        return people.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
    }


}
