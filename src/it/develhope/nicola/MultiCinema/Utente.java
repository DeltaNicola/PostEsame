package it.develhope.nicola.MultiCinema;

/**
 * classe che gestisce l'utente che prenota
 * @author nicolameloni
 */
public class Utente {

    /**
     * nome dell'Utente
     */
    private final String name;
    /**
     * cognome dell'Utente
     */
    private final String surname;

    /**
     * Costruttore per inizializzare utente vuoto
     */
    public Utente(){
        this.name = "Utente";
        this.surname = "Vuoto";
    }

    /**
     * Costruttore per inizializzare utente non vuoto
     * @param name nome dell'utente
     * @param surname cognome dell'utente
     */
    public Utente(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    /**
     * metodo per restituire la stringa utente
     * @return nome e cognome dell'utente come stringa
     */
    @Override
    public String toString() {
        return "Utente{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
