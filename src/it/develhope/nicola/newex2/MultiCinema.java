package it.develhope.nicola.newex2;
import java.util.*;

/**
 * classe che gestisce un multisala
 * @author nicolameloni
 */
public class MultiCinema {

    /**
     * cine: assegna ad un Manager un Cinema
     */
    private final Map<Manager, Cinema> cine;
    private final Scanner input;

    /**
     * Costruttore per inizializzare gli attributi<br>
     * cine è vuoto
     */
    public MultiCinema() {
        this.cine = new HashMap<>();
        input = new Scanner(System.in);
    }

    /**
     * visualizza ogni comando possibile nel menù
     */
    private void seeOpt(){
        System.out.println("Inserire il comando:");
        System.out.println("1: Inserire Manager");
        System.out.println("2: Login");
        System.out.println("3: Stampare Lista Manager");
        System.out.println("4: Chiudere il programma");
    }

    /**
     * crea un Manager tramite input<br>
     * @return inizializzazione del Manager
     */
    private Manager createManager(){
        input.nextLine();
        System.out.println("Inserire nome:");
        String nomeLog = input.nextLine();
        System.out.println("Inserire cognome:");
        String cognomeLog = input.nextLine();
        return new Manager(nomeLog, cognomeLog);
    }

    /**
     * Controlla l'esistenza di un Manager
     * @param x Manager da cercare nella Map cine
     * @return true se Manager esiste, false se non esiste
     */
    private boolean checkManager(Manager x){
        for(Manager y : cine.keySet()){
            if(y.toString().equalsIgnoreCase(x.toString())){
                return true;
            }
        }
        return false;
    }

    /**
     * Aggiunge un Manager alla Map cine e gli assegna un Cinema<br>
     * controllo dell'esistenza precedente del Manager
     */
    private void addManager(){
        Manager x = createManager();
        if(checkManager(x)){
            System.out.println("Manager già esistente!");
        } else {
            Cinema y = new Cinema();
            cine.put(x, y);
        }
    }

    public void addManager(List<Manager> x){
        for(Manager y : x){
            Cinema z = new Cinema();
            cine.put(y,z);
        }
    }

    /**
     * login: accedere ad un Cinema attraverso key Manager<br>
     * controllo dell'esistenza precedenza del Manager
     */
    private void login(){
        Manager log = createManager();
        if(checkManager(log)){
            cine.get(log).menu();
        } else {
            System.out.println("Manager non corretto o non esistente!");
        }
    }

    /**
     * Stampa a schermo la lista dei Manager
     */
    private void listaManager(){
        for(Manager x : cine.keySet()){
            System.out.println(x.toString());
        }
    }

    /**
     * menù di interazione in base all'input <br>
     * controllo dell'input e chiamata della funzione prescelta<br>
     * 1 -> aggiunge un Manager<br>
     * 2 -> effettua il login<br>
     * 3 -> stampa lista Manager<br>
     * 4 -> chiude il programma<br>
     * 0, 5-9 -> non ha comandi stabiliti<br>
     * @throws InputMismatchException se input non è numerico
     */
    public void menu(){
        boolean loop = false;
        do{
            try {
                int x;
                do {
                    seeOpt();
                    x = input.nextInt();
                    switch (x) {
                        case 1 -> addManager();
                        case 2 -> login();
                        case 3 -> listaManager();
                        case 4 -> System.out.println("Chiusura programma!");
                        default -> System.out.println("Comando non valido!");
                    }
                } while (x != 4);
                loop = true;
            }catch (InputMismatchException e){
                System.out.println("Comando non idoneo!");
                input.nextLine();
            }
        }while(!loop);
    }
}
