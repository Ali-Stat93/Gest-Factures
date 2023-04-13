package org.example.model;

public enum Categorie {
    INFORMATIQUE(1,"Informatique"),
    BUREAUTIQUE(2,"Bureatique");
    private final int code;
    private final String nom;
    Categorie(int code,String nom) {
        this.code=code;
        this.nom=nom;
    }
}
