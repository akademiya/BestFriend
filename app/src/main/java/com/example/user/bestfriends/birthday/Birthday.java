package com.example.user.bestfriends.birthday;

public class Birthday {

    int birthdayID;
    String person_name;
    String date_birthday;

    public Birthday(int birthdayID, String person_name, String date_birthday) {
        this.birthdayID = birthdayID;
        this.person_name = person_name;
        this.date_birthday = date_birthday;
    }

    public Birthday(String person_name, String date_birthday) {
        this.person_name = person_name;
        this.date_birthday = date_birthday;
    }

    public int getBirthdayID() { return birthdayID; }
    public String getPerson_name() { return person_name; }
    public String getDate_birthday() { return date_birthday; }
}