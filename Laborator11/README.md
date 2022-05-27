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
-
POST http://localhost:8081/persons
Content-Type: application/json
-
{
  "id": 4,
  "name": "Raluk",
  "age": "21"
}
