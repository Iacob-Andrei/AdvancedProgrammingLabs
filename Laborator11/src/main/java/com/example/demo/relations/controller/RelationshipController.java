package com.example.demo.relations.controller;

import com.example.demo.person.Person;
import com.example.demo.relations.Relationship;
import com.example.demo.relations.services.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("relationship")
public class RelationshipController {

    private final RelationshipService relationshipService;

    @Autowired
    public RelationshipController(RelationshipService relationshipService) {
        this.relationshipService = relationshipService;
    }

    @GetMapping
    public List<Relationship> getRelationships(){
        return relationshipService.getRelationships();
    }
    
    @PostMapping
    public void addNewRelationship(@RequestBody Relationship relation){
        relationshipService.addNewRelation(relation);
    }

    @GetMapping( path = "/popular/{firstN}")
    public List<Optional<Person>> mostPopular(@PathVariable("firstN") int number){
       return  relationshipService.getMostPopular(number);
    }
}
