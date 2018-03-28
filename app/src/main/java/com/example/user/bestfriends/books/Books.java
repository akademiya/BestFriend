package com.example.user.bestfriends.books;


public class Books {
    private int id;
    private int icon_books;
    private String name_books;
    private String website;

    public Books(int id, int icon_books, String name_books, String website) {
        this.id = id;
        this.icon_books = icon_books;
        this.name_books = name_books;
        this.website = website;
    }

    public int getIcon_books() {return icon_books;}
    public void setIcon_books(int icon_books) {this.icon_books = icon_books;}

    public String getName_books() {return name_books;}
    public void setName_books(String name_books) {this.name_books = name_books;}

    public String getWebsite() {
        return website;
    }
}
