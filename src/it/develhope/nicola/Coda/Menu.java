package it.develhope.nicola.Coda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private List<Persona> coda;
    private Scanner input;
    private String[] dati;

    public Menu() {
        input = new Scanner(System.in);
        coda = new ArrayList<>();
        dati = new String[3];
    }

    private void setData(String utente){
        switch (utente){
            case "Privato" -> {
                System.out.println("Codice Fiscale:");
                dati[0] = input.nextLine();
                input.nextLine();
                System.out.println("Nome:");
                dati[1] = input.nextLine();
                System.out.println("Cognome:");
                dati[2] = input.nextLine();
            }
            case "Business" -> {
                System.out.println("Nome Azienda:");
                dati[0] = input.nextLine();
                input.nextLine();
                System.out.println("Nome:");
                dati[1] = input.nextLine();
                System.out.println("Cognome:");
                dati[2] = input.nextLine();
            }
        }
    }

    private void addPrivato(){
        Persona x;
        System.out.println("Inserire dati privato:");
        setData("Privato");
        x = new Privato(dati[0], dati[1], dati[2]);
        coda.add(x);
    }

    private void addBusiness(){
        Persona x;
        System.out.println("Inserire dati business:");
        setData("Business");
        x = new Business(dati[0], dati[1], dati[2]);
        coda.add(x);
    }

    private void servClient(){
        try{
            System.out.println("Ho servito un cliente " + coda.get(0).getClass().getSimpleName());
            coda.remove(0);
        }catch (Exception e){
            System.out.println("Nessun utente in coda!");
        }
    }

    public void addPersona() {
        System.out.println("Inserire nuovo utente in coda? 1 Privato / 2 Business / 3 Servi / 4 Esci");
        int z = input.nextInt();
        switch (z) {
            case 1 -> {
                addPrivato();
                addPersona();
            }
            case 2 -> {
                addBusiness();
                addPersona();
            }
            case 3 -> {
                servClient();
                addPersona();
            }
            case 4 -> System.out.println("Programma Terminato!");
            default -> {
                System.out.println("Comando non valido!");
                addPersona();
            }
        }
    }
}
