package com.example.user.bestfriends.list_kido;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Person {

    @PrimaryKey(autoGenerate = true)
    private int personID;

    @ColumnInfo(name = "personPhoto")
    private int personPhoto;

    @ColumnInfo(name = "personName")
    private String personName;

    public Person(int personPhoto, String personName) {
        this.personPhoto = personPhoto;
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