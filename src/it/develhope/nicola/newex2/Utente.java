package it.develhope.nicola.newex2;

import java.util.Scanner;

public class Utente {
    private String name;
    private String surname;

    public Utente(){
        this.name = "Utente";
        this.surname = "Vuoto";
    }

    public Utente(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void setAll(){
    }

    @Override
    public String toString() {
        return "Utente{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
