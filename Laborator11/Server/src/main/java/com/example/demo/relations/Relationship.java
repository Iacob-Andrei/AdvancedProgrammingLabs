package com.example.demo.relations;

import com.example.demo.person.Person;

import javax.persistence.*;

@Entity
@Table
public class Relationship {

    @Id
    @SequenceGenerator(name = "relationship_sequence", sequenceName = "relationship_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "relationship_sequence")
    private Long id;

    @ManyToOne
    @JoinColumn( name = "idPerson1", referencedColumnName = "id" )
    private Person person1;

    @ManyToOne
    @JoinColumn( name = "idPerson2", referencedColumnName = "id" )
    private Person person2;

    public Relationship(){
    }

    public Relationship(Person person1, Person person2){
        this.person1 = person1;
        this.person2 = person2;
    }

    public Relationship(Long id, Person person1, Person person2){
        this.id = id;
        this.person1 = person1;
        this.person2 = person2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson1() {
        return person1;
    }

    public void setPerson1(Person person1) {
        this.person1 = person1;
    }

    public Person getPerson2() {
        return person2;
    }

    public void setPerson2(Person person2) {
        this.person2 = person2;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Relationship{");

        sb.append("id=").append(id);
        sb.append(", person1=").append(person1);
        sb.append(", person2=").append(person2);
        sb.append('}');
        return sb.toString();
    }
}
