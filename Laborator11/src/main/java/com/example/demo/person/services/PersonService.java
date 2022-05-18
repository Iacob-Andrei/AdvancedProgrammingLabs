package com.example.demo.person.services;

import com.example.demo.person.Person;
import com.example.demo.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPeople(){
        return personRepository.findAll();
    }

    public void addNewPerson(Person person) {
        if( person.getId() != null )
            if( personRepository.findById(person.getId()).isPresent() )
                throw new IllegalStateException("id taken");

        personRepository.save(person);
    }

    public void deletePerson(Long id) {
        if( !personRepository.existsById(id) )
            throw new IllegalStateException("id invalid!");

        personRepository.deleteById(id);
    }

    public Optional<Person> findById(Long id) {
        if( !personRepository.existsById(id) )
            throw new IllegalStateException("id invalid!");

        return personRepository.findById(id);
    }

    @Transactional
    public void updatePerson(Long personId, String name) {

        Person person = personRepository.findById(personId)
                                    .orElseThrow(() -> new IllegalStateException("Id invalid"));

        if( !personRepository.existsById(personId) )
            throw new IllegalStateException("id invalid!");

        if( name != null && name.length() > 0 )
            person.setName(name);
    }
}
