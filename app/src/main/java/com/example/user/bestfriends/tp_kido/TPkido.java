package com.example.user.bestfriends.tp_kido;

public class TPkido {
    private int tpkidoID;
    private int nameTPkido;
    private String website;

    public TPkido(int nameTPkido, String website) {
        this.nameTPkido = nameTPkido;
        this.website = website;
    }

    public TPkido(int tpkidoID, int nameTPkido, String website) {
        this.tpkidoID = tpkidoID;
        this.nameTPkido = nameTPkido;
        this.website = website;
    }

    public int getTpkidoID() { return tpkidoID; }
    public int getNameTPkido() { return nameTPkido; }
    public String getWebsite() { return website; }
}