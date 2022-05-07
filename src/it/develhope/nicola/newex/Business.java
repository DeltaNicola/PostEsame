package it.develhope.nicola.newex;

public class Business extends Persona{
    private String azienda;

    public Business(String name, String surname, String azienda) {
        super(name, surname);
        this.azienda = azienda;
    }
}
