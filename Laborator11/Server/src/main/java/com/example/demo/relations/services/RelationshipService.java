package com.example.demo.relations.services;

import com.example.demo.person.Person;
import com.example.demo.person.repository.PersonRepository;
import com.example.demo.relations.Relationship;
import com.example.demo.relations.repository.RelationshipRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RelationshipService {

    private final RelationshipRepository relationshipRepository;
    private final PersonRepository personRepository;

    public RelationshipService(RelationshipRepository relationshipRepository, PersonRepository personRepository) {
        this.relationshipRepository = relationshipRepository;
        this.personRepository = personRepository;
    }

    public List<Relationship> getRelationships(){
        return relationshipRepository.findAll();
    }

    public Optional<Relationship> getRelation(Long id){
        if( !relationshipRepository.existsById(id) )
            throw new IllegalStateException("id invalid!");

        return relationshipRepository.findById(id);
    }

    public void addNewRelation(Relationship relation) {

        if( !personRepository.existsById(relation.getPerson1().getId()) )
            throw new IllegalStateException("id1 invalid!");

        if( !personRepository.existsById(relation.getPerson2().getId()) )
            throw new IllegalStateException("id2 invalid!");

        Person person1 =  personRepository.getById(relation.getPerson1().getId() );
        Person person2 =  personRepository.getById(relation.getPerson2().getId() );

        relation.setPerson1(person1);
        relation.setPerson2(person2);
        relationshipRepository.save(relation);

        Relationship inverted = new Relationship(person2, person1);
        relationshipRepository.save(inverted);
    }

    public List<Optional<Person>> getMostPopular(int number) {

        List<Long> ids = relationshipRepository.findTopByPerson1().subList(0, number);

        List<Optional<Person>> firstPeople = new ArrayList<>();
        ids.forEach(id -> firstPeople.add(personRepository.findById(id)));
        return firstPeople;
    }
}
