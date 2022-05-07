package it.develhope.nicola.newex2;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cinema {
    enum Posto {
        LIBERO,
        OCCUPATO
    }
    private final Posto[] seat;
    private final Scanner input;

    public Cinema(){
        seat = new Posto[10];
        for(int i=0; i<10; i++) {
            seat[i] = Posto.LIBERO;
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
            if(seat[i].name().equals("LIBERO")){
                j++;
            }
        }
        System.out.println("Posti disponibili: "+j);
    }

    private void takePosto(){
        boolean check = false;
        for(int i=0; i<10; i++){
            if(seat[i].name().equals("LIBERO")){
                check = true;
                seat[i] = Posto.OCCUPATO;
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
            if(seat[i].name().equals("OCCUPATO")){
                check = true;
                seat[i] = Posto.LIBERO;
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
