package it.develhope.nicola.Coda;

public class Privato extends Persona {
    private String codFiscale;

    public Privato(String codFiscale, String name, String surname){
        super(name, surname);
        this.codFiscale=codFiscale;
    }
}
