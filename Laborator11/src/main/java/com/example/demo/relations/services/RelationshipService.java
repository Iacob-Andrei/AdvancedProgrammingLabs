package com.example.demo.relations.services;

import com.example.demo.person.repository.PersonRepository;
import com.example.demo.relations.Relationship;
import com.example.demo.relations.repository.RelationshipRepository;
import org.springframework.stereotype.Service;

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

        // TODO check
        //  if relation.getPerson1() and relation.getPerson1() exists
        //  if ok, add to relationship table
    }
}
