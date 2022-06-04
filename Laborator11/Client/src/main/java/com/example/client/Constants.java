package com.example.client;

public class Constants {

    public static final String GET_ALL_PERSONS = "localhost:8081/persons";
    public static final String GET_PERSON_BY_ID = "localhost:8081/persons/{personsId}";
    public static final String POST_ADD_PERSON = "localhost:8081/persons";
    public static final String PUT_PERSON = "localhost:8081/persons/update/{personId}";
    public static final String GET_ALL_RELATIONSHIPS = "localhost:8081/relationship";
    public static final String GET_RELATIONSHIP_BY_ID = "localhost:8081/relationship/{idRelationship}";
    public static final String GET_POPULAR_RELATIONSHIP = "localhost:8081/relationship/popular/{firstN}";

}
