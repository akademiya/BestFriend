package com.example.user.bestfriends.contacts;


public class Contacts {

    private int contactsID;
    private int personPhoto;
    private String personName;
    private String personBirthday;
    private String personTelephone;
    private String personEmail;
    private String personChukpok;

    public Contacts(int contactsID,
                    String personName,
                    String personBirthday,
                    String personTelephone,
                    String personEmail,
                    String personChukpok) {
        this.contactsID = contactsID;
//        this.personPhoto = personPhoto;
        this.personName = personName;
        this.personBirthday = personBirthday;
        this.personTelephone = personTelephone;
        this.personEmail = personEmail;
        this.personChukpok = personChukpok;
    }

    public Contacts(String personName,
                    String personBirthday,
                    String personTelephone,
                    String personEmail,
                    String personChukpok) {
//        this.personPhoto = personPhoto;
        this.personName = personName;
        this.personBirthday = personBirthday;
        this.personTelephone = personTelephone;
        this.personEmail = personEmail;
        this.personChukpok = personChukpok;
    }

    public int getContactsID() {
        return contactsID;
    }

    public void setContactsID(int contactsID) {
        this.contactsID = contactsID;
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

    public String getPersonBirthday() {
        return personBirthday;
    }

    public void setPersonBirthday(String personBirthday) {
        this.personBirthday = personBirthday;
    }

    public String getPersonTelephone() {
        return personTelephone;
    }

    public void setPersonTelephone(String personTelephone) {
        this.personTelephone = personTelephone;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public String getPersonChukpok() {
        return personChukpok;
    }

    public void setPersonChukpok(String personChukpok) {
        this.personChukpok = personChukpok;
    }


}