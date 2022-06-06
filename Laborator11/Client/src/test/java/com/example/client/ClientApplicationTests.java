package com.example.client;

import com.example.client.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ClientApplicationTests {

    private static final String URL = "localhost:8081";
    private final WebClient webClient = WebClient.create();
    RestClient restClient = new RestClient(webClient);

    @Test
    void getAllPersons() {
        List<Person> userList = restClient.getAllPersons();
        System.out.println("personList : " + userList );
        assertTrue(userList.size() > 0);
    }

    @Test
    void getPersonById(){
        Person person = restClient.getPersonById(1);
        assertNotNull(person);
        System.out.println(person);
    }
}
