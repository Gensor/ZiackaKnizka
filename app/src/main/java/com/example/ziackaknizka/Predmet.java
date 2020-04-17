package com.example.ziackaknizka;

public enum Predmet {
    APG("Aplikovana pocitacova grafika"),
    UI("Umela inteligencia"),
    PDA("Programovanie databazovych aplikacii"),
    VMA("Vyvoj mobilnych aplikacii");

    private String nazov;

    public String getNazov() {
        return nazov;
    }
    Predmet(String nazov){
        this.nazov=nazov;
    }
}
