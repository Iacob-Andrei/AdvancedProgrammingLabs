package com.example.demo.relations.services;

import com.example.demo.relations.Relationship;
import com.example.demo.relations.repository.RelationshipRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RelationshipService {

    private final RelationshipRepository relationshipRepository;

    public RelationshipService(RelationshipRepository relationshipRepository) {
        this.relationshipRepository = relationshipRepository;
    }

    public List<Relationship> getRelationships(){
        return relationshipRepository.findAll();
    }

    public Optional<Relationship> getRelation(Long id){
        if( !relationshipRepository.existsById(id) )
            throw new IllegalStateException("id invalid!");

        return relationshipRepository.findById(id);
    }
}
