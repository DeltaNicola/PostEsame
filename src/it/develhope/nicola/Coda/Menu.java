package it.develhope.nicola.Coda;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * classe per gestire la Coda di Persona
 * @author nicolameloni
 */
public class Menu {

    /**
     * insieme delle Persona generale <br>
     * si specifica più avanti il tipo di Persona
     */
    private List<Persona> coda;
    private Scanner input;
    /**
     * array di aiuto di inserimento dei dati
     */
    private String[] dati;

    /**
     * Costruttore di inizializzazione degli attributi
     */
    public Menu() {
        input = new Scanner(System.in);
        coda = new ArrayList<>();
        dati = new String[3];
    }

    /**
     * funzione per inserire i dati di una sottoclasse di Persona <br>
     * inserimento di un Privato o Business secondo parametro
     * @param utente parametro per la specializzazione di utente Persona in Business o Privato
     */
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

    /**
     * funzione che chiama la creazione di un utente Privato
     */
    private void addPrivato(){
        Persona x;
        System.out.println("Inserire dati privato:");
        setData("Privato");
        x = new Privato(dati[0], dati[1], dati[2]);
        coda.add(x);
    }

    /**
     * funzione di chiamata per la creazione di un utente Business
     */
    private void addBusiness(){
        Persona x;
        System.out.println("Inserire dati business:");
        setData("Business");
        x = new Business(dati[0], dati[1], dati[2]);
        coda.add(x);
    }

    /**
     * funzione che controlla il tipo di sottoClasse della prima Persona della lista <br>
     * @throws Exception se non vi sono utenti in Coda
     */
    private void servClient(){
        try{
            System.out.println("Ho servito un cliente " + coda.get(0).getClass().getSimpleName());
            coda.remove(0);
        }catch (Exception e){
            System.out.println("Nessun utente in coda!");
        }
    }

    /**
     * menù di interazione in base all'input <br>
     * controllo dell'input e chiamata della funzione prescelta<br>
     * 1 -> aggiunge una Persona - Privato<br>
     * 2 -> aggiunge una Persona - Business<br>
     * 3 -> serve il primo utente della lista riconoscendo la sottoclasse di Persona<br>
     * 4 -> chiude il programma<br>
     * 0, 5-9 -> non ha comandi stabiliti<br>
     */
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
