package it.develhope.nicola.newex2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tester {
    public static void main(String[] args){
        List<Manager> managerList = new ArrayList<>();
        managerList.add(0, new Manager("romolo", "lupo"));
        managerList.add(1, new Manager("numa", "pompilio"));
        managerList.add(2, new Manager("tullio", "stilio"));
        managerList.add(3, new Manager("anco", "marzio"));
        managerList.add(4, new Manager("tarquinio", "prisco"));
        managerList.add(5, new Manager("servio", "tullio"));
        managerList.add(6, new Manager("tarquinio", "il superbo"));
        Collections.shuffle(managerList);
        MultiSala cine = new MultiSala();
        cine.addManager(managerList);
        cine.menu();
    }
}
