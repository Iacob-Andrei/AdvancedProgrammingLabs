package com.example.demo.relations.repository;

import com.example.demo.relations.Relationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationshipRepository extends JpaRepository<Relationship, Long> {

    @Query("SELECT person1.id FROM Relationship GROUP BY person1 ORDER BY count(person1) DESC")
    List<Long> findTopByPerson1();
}
