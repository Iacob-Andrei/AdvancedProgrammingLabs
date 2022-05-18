package com.example.demo.person.controller;

import com.example.demo.person.Person;
import com.example.demo.person.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPeople(){
        return personService.getPeople();
    }

    @GetMapping(path="{personId}")
    public Optional<Person> getPersonById(@PathVariable("personId") Long id){
        return personService.findById(id);
    }

    @PostMapping
    public void addNewPerson(@RequestBody Person person){
        personService.addNewPerson(person);
    }

    @DeleteMapping(path="/delete/{personId}")
    public void deletePerson(@PathVariable("personId") Long id){
        personService.deletePerson(id);
    }

    @PutMapping(path = "/update/{personId}")
    public void updatePerson(@PathVariable("personId") Long personId, @RequestParam(required = false) String name){
        personService.updatePerson(personId, name);
    }
}
