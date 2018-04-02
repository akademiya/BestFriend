package com.example.user.bestfriends.list_kido;

public class Person {
    private int personID;
    private int personPhoto;
    private String personName;

    public Person(int personID, String personName) {
        this.personID = personID;
//        this.personPhoto = personPhoto;
        this.personName = personName;
    }

    public Person(String personName) {
//        this.personPhoto = personPhoto;
        this.personName = personName;
    }

    public int getPersonID() {
        return personID;
    }
    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public int getPersonPhoto() {
        return personPhoto;
    }
    public void setPersonPhoto(int personPhoto) {
        this.personPhoto = personPhoto;
    }

    public String getPersonName() {
        return personName;
    }
    public void setPersonName(String personName) {
        this.personName = personName;
    }
}