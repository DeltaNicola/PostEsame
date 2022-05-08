package it.develhope.nicola.Coda;

/**
 * classe per gestire gli utenti Persona - Business
 * @author nicolameloni
 */
public class Business extends Persona{
    /**
     * attributo distintivo della Persona - Business
     */
    private String azienda;

    /**
     * Costruttore parametrico
     * @param azienda azienda del Business in input
     * @param name nome della Persona in input
     * @param surname cognome della Persona in input
     */
    public Business(String name, String surname, String azienda) {
        super(name, surname);
        this.azienda = azienda;
    }
}
