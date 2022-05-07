package it.develhope.nicola.newex2;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cinema {
    private final boolean[] seat;
    private final Utente[] user;
    private final Scanner input;

    public Cinema(){
        seat = new boolean[10];
        user = new Utente[10];
        for(int i=0; i<10; i++) {
            seat[i] = true;
            user[i] = new Utente();
        }
        input = new Scanner(System.in);
    }

    private void seeOpt(){
        System.out.println("Inserire il comando desiderato:");
        System.out.println("1: Visualizzare i posti disponibili");
        System.out.println("2: Prenotare un posto");
        System.out.println("3: Cancellare la prenotazione");
        System.out.println("4: Uscire dal programma");
    }
    
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

    private Utente setUser(boolean x, int i){
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

    private void takePosto(){
        boolean check = false;
        for(int i=0; i<10; i++){
            if(seat[i]){
                check = true;
                seat[i] = false;
                user[i] = setUser(seat[i], i);
                i=10;
            }
        }
        if(!check) {
            System.out.println("Nessun posto disponibile!");
        }
    }

    private void delPosto(){
        boolean check = false;
        for(int i=9; i>-1; i--){
            if(!seat[i]){
                check = true;
                seat[i] = true;
                user[i] = setUser(seat[i], i);
                i=0;
            }
        }
        if (!check) {
            System.out.println("Nessuna prenotazione da cancellare!");
        }
    }

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
