package com.example.user.bestfriends.list_kido.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.user.bestfriends.list_kido.Person;

import java.util.List;

@Dao
public interface UserDao {
    @Query( "SELECT * FROM Person" )
    List<Person> getAllUsers();

    @Query("SELECT * FROM Person WHERE personID = :id")
    List<Person> getPersonByID(long id);

    @Insert
    void insertAll(Person persons);

    @Delete
    void deletePerson(Person persons);

}