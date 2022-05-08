package it.develhope.nicola.Coda;

/**
 * classe per gestire gli utenti Persona - Privato
 * @author nicolameloni
 */
public class Privato extends Persona {
    /**
     * attributo distintivo della Persona - Privato
     */
    private String codFiscale;

    /**
     * Costruttore parametrico
     * @param codFiscale codFiscale del Privato in input
     * @param name nome della Persona in input
     * @param surname cognome della Persona in input
     */
    public Privato(String codFiscale, String name, String surname){
        super(name, surname);
        this.codFiscale=codFiscale;
    }
}
