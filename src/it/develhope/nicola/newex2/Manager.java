package it.develhope.nicola.newex2;

public record Manager(String name, String surname) {
    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
