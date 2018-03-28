package com.example.user.bestfriends.list_kido;


public class ListKido {

    private int person_photo;
    private String person_name;
    private boolean check;

    public ListKido() {}

    public ListKido(int photo, String name, Boolean check) {
        this.person_photo = photo;
        this.person_name = name;
        this.check = check;
    }

    public int getPerson_photo() { return person_photo; }

    public void setPersonPhoto(int person_photo) { this.person_photo = person_photo; }

    public String getPersonName() { return person_name; }

    public void setPersonName(String person_name) { this.person_name = person_name; }

    public boolean getCheck() { return check; }

    public void setCheck(boolean check) { this.check = check; }
}
