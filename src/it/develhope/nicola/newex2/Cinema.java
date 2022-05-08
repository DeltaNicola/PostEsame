package it.develhope.nicola.newex2;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * classe che gestisce un'unica sala del cinema
 * @author nicolameloni
 */
public class Cinema {

    /**
     * attributi:
     * seat[]: nota se il posto è libero od occupato
     * user[]: assegna un nominativo al posto occupato
     */
    private final boolean[] seat;
    private final Utente[] user;
    private final Scanner input;

    /**
     * Costruttore per inizializzare le variabili
     * seat: ogni posto è libero
     * user: ogni utente è vuoto
     */
    public Cinema(){
        seat = new boolean[10];
        user = new Utente[10];
        for(int i=0; i<10; i++) {
            seat[i] = true;
            user[i] = new Utente();
        }
        input = new Scanner(System.in);
    }

    /**
     * visualizza ogni comando possibile nel menù
     */
    private void seeOpt(){
        System.out.println("Inserire il comando desiderato:");
        System.out.println("1: Visualizzare i posti disponibili");
        System.out.println("2: Prenotare un posto");
        System.out.println("3: Cancellare la prenotazione");
        System.out.println("4: Uscire dal programma");
    }

    /**
     * visualizza i posti diponibili
     * se seat[index] == falso -> non è disponibile
     */
    private void seeDisp(){
        int j=0;
        for(int i=0; i<10; i++){
            if(seat[i]){
                j++;
            }else{
                System.out.println(user[i].toString());
            }
        }
        System.out.println("Posti disponibili: "+j);
    }

    /**
     * assegna un utente al posto in base al booleano di controllo
     * l'utente ha nome e cognome se il posto deve essere occupato
     * l'utente ha nome e cognomi vuoti se il posto deve essere liberato
     * @param x booleano di controllo
     * @return utente completo o vuoto
     */
    private Utente setUser(boolean x){
        if(!x){
            System.out.println("Inserire nome:");
            input.nextLine();
            String name = input.nextLine();
            System.out.println("Inserire cognome:");
            String surname = input.nextLine();
            return new Utente(name, surname);
        }else{
            return new Utente();
        }
    }

    /**
     * prenotazione del posto
     * controllo della disponibilità dei posti
     */
    private void takePosto(){
        boolean check = false;
        for(int i=0; i<10; i++){
            if(seat[i]){
                check = true;
                seat[i] = false;
                user[i] = setUser(seat[i]);
                i=10;
            }
        }
        if(!check) {
            System.out.println("Nessun posto disponibile!");
        }
    }

    /**
     * cancellazione della prenotazione
     * controllo dell'esistenza di precedenti prenotazioni
     */
    private void delPosto(){
        boolean check = false;
        for(int i=9; i>-1; i--){
            if(!seat[i]){
                check = true;
                seat[i] = true;
                user[i] = setUser(seat[i]);
                i=0;
            }
        }
        if (!check) {
            System.out.println("Nessuna prenotazione da cancellare!");
        }
    }

    /**
     * menù di interazione in base all'input
     * controllo dell'input e chiamata della funzione prescelta
     * @throws InputMismatchException se input non è numerico
     * 1 -> vede la disponibilità dei posti
     * 2 -> prenota un posto
     * 3 -> cancella la prenotazione
     * 4 -> chiude il programma
     * 0, 5-9 -> non ha comandi stabiliti
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
                        case 1 -> seeDisp();
                        case 2 -> takePosto();
                        case 3 -> delPosto();
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
