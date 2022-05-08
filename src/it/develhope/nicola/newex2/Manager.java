package it.develhope.nicola.newex2;

/**
 * record per gestire il manager di controllo
 * @author nicolameloni
 * @param name nome del manager
 * @param surname cognome del manager
 */
public record Manager(String name, String surname) {

    /**
     * metodo per restituire la stringa manager<br>
     * @return nome e cognome del manager come stringa
     */
    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
