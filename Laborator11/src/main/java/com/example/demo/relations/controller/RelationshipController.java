package com.example.demo.relations.controller;

import com.example.demo.relations.Relationship;
import com.example.demo.relations.services.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
