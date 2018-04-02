package com.example.user.bestfriends.list_kido;

public class Person {
    private int personID;
    private String personName;

    public Person(int personID, String personName) {
        this.personID = personID;
        this.personName = personName;
    }

    public Person(String personName) {
        this.personName = personName;
    }

    public int getPersonID() {
        return personID;
    }
    public String getPersonName() {
        return personName;
    }
}