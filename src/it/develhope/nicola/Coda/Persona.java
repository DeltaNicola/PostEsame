package it.develhope.nicola.Coda;

/**
 * classe per gestire gli utenti Persona
 * @author nicolameloni
 */
public class Persona {
    /**
     * nome della Persona
     */
    private String name;
    /**
     * cognome della Persona
     */
    private String surname;

    /**
     * Costruttore parametrico
     * @param name nome della Persona in input
     * @param surname cognome della Persona in input
     */
    public Persona(String name, String surname){
        this.name=name;
        this.surname=surname;
    }
}
