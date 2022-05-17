package com.lab11.laborator11;

public class Person {
    private String name;
    private int id;
    private String surname;
    private int age;
    private String nationality;

    public Person(int id,String name, String surname, int age, String nationality) {
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.nationality = nationality;
    }

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
