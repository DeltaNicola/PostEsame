package it.develhope.nicola.newex2;
import java.util.*;

public class MultiSala {
    private final Map<Manager, Sala> cine;
    private final Scanner input;

    public MultiSala() {
        this.cine = new HashMap<>();
        input = new Scanner(System.in);
    }

    private void seeOpt(){
        System.out.println("Inserire il comando:");
        System.out.println("1: Inserire Manager");
        System.out.println("2: Login");
        System.out.println("3: Stampare Lista Manager");
        System.out.println("4: Chiudere il programma");
    }

    private Manager createManager(){
        input.nextLine();
        System.out.println("Inserire nome:");
        String nomeLog = input.nextLine();
        System.out.println("Inserire cognome:");
        String cognomeLog = input.nextLine();
        return new Manager(nomeLog, cognomeLog);
    }

    private boolean checkManager(Manager x){
        for(Manager y : cine.keySet()){
            if(y.toString().equalsIgnoreCase(x.toString())){
                return true;
            }
        }
        return false;
    }

    private void addManager(){
        Manager x = createManager();
        if(checkManager(x)){
            System.out.println("Manager già esistente!");
        } else {
            Sala y = new Sala();
            cine.put(x, y);
        }
    }

    public void addManager(List<Manager> x){
        for(Manager y : x){
            Sala z = new Sala();
            cine.put(y,z);
        }
    }

    private void login(){
        Manager log = createManager();
        if(checkManager(log)){
            cine.get(log).menu();
        } else {
            System.out.println("Manager non corretto o non esistente!");
        }
    }

    private void listaManager(){
        for(Manager x : cine.keySet()){
            System.out.println(x.toString());
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
