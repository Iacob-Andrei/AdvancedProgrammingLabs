package com.example.client;

import com.example.client.model.Person;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static com.example.client.Constants.*;

public class RestClient {
    private WebClient webClient;

    public RestClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<Person> getAllPersons() {
        return webClient.get().uri( GET_ALL_PERSONS)
                .retrieve()
                .bodyToFlux(Person.class)
                .collectList()
                .block();
    }

    public Person getPersonById(int id) {
        return webClient.get().uri(GET_PERSON_BY_ID, id)
                .retrieve()
                .bodyToMono(Person.class)
                .block();
    }

    public void addPerson(Person user) {
        webClient.post().uri(POST_ADD_PERSON)
                .bodyValue(user);
    }

    public void updatePerson(int id, Person user) {
        webClient.put().uri(PUT_PERSON, id);
    }

    public void deletePersonById(int id) {
        webClient.delete().uri(GET_PERSON_BY_ID,id);
    }
}