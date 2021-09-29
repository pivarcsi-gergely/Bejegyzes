package hu.petrik;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Bejegyzes> bejegyzesLista = new ArrayList<>();

    public static void felhaszKiirat(){
        System.out.println("Te is meg tudsz adni bejegyzés(eke)t! Adj meg egy sorszámot (ennyi bejegyzést fogsz kiírni)!");
        String beolvasottSor = sc.nextLine();
        int beolvasSorSzam = Integer.parseInt(beolvasottSor);
            if (beolvasSorSzam == 0){
                System.out.println("Látom, nem adott meg sorszamot");
            }
    }

    public static void main(String[] args) {
        Bejegyzes b1 = new Bejegyzes("Ben Affleck", "Totalra nem tudom, mit keresek itt.");
        Bejegyzes b2 = new Bejegyzes("Jozska", "Utalom a beragado Shift billentyuket.");
        bejegyzesLista.add(b1);
        bejegyzesLista.add(b2);

        System.out.println("Köszöntelek! Ez a program egy portál bejegyzéseivel foglalkozik!");

        felhaszKiirat();


    }
}
