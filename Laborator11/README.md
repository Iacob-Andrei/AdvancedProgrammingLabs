Compulsory & Homework
-
- Spring Boot project

- [/](https://localhost:8081)
  - prints "hello world"
- [/persons](https://localhost:8081/persons)
  - HTTP GET request, return list of persons
- [/persons/{personId}](https://localhost:8081/2)    
  - HTTP GET request, return person with id {personID}
- [/persons]
  - HTTP POST request example: 
POST http://localhost:8081/persons
Content-Type: application/json

{
  "id": 4,
  "name": "Raluk",
  "age": "21"
}
