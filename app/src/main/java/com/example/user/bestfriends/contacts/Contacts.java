package com.example.user.bestfriends.contacts;


public class Contacts {

    private int contactsID;
    private String personName;
    private String personTelephone;
    private String personEmail;

    public Contacts(int contactsID,
                    String personName,
                    String personTelephone,
                    String personEmail) {
        this.contactsID = contactsID;
        this.personName = personName;
        this.personTelephone = personTelephone;
        this.personEmail = personEmail;
    }

    public Contacts(String personName,
                    String personTelephone,
                    String personEmail) {
        this.personName = personName;
        this.personTelephone = personTelephone;
        this.personEmail = personEmail;
    }

    public int getContactsID() {
        return contactsID;
    }
    public String getPersonName() {
        return personName;
    }
    public String getPersonTelephone() {
        return personTelephone;
    }
    public String getPersonEmail() {
        return personEmail;
    }
}