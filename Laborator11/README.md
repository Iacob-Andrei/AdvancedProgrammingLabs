Compulsory & Homework
-
- Spring Boot project

- [localhost:8081/](https://localhost:8081)
  - prints "hello world"
- [localhost:8081/persons](https://localhost:8081/persons)
  - HTTP GET request, return list of persons
- [localhost:8081/persons/{personId}](https://localhost:8081/2)    
  - HTTP GET request, return person with id {personID}
- [localhost:8081/persons](https://localhost:8081/persons)  
  - HTTP POST request example:
      - POST http://localhost:8081/persons
      - Content-Type: application/json
{
  "id": 4,
  "name": "Raluk",
  "age": "21"
}
- [localhost:8081//delete/{personId}](https://localhost:8081/persons/delete/1)
  - HTTP DELETE request
- [localhost:8081/persons/update/{personId}](https://localhost:8081/persons/update/{personId})  
  - HTTP PUT request, updades person with specified id   
    - PUT [localhost:8081/persons/update/1?name=Raluk](http://localhost:8081/persons/update/4?name=Raluk)
