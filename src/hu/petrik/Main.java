package hu.petrik;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
                System.out.println("Látom, nem adott meg sorszámot. Akkor lépjünk is tovább!");
            }
            else{
                for (int i = 0; i < beolvasSorSzam; i++) {
                    System.out.println("A bejegyzés szerzője?");
                    String szerzo = sc.nextLine();
                    System.out.println("A bejegyzés tartalma?");
                    String tartalom = sc.nextLine();
                    System.out.println();
                    bejegyzesLista.add(new Bejegyzes(szerzo, tartalom));
                    System.out.println("Bejegyzés hozzáadva a listához. \n");
                }
            }
    }

    public static void fajlBeolvasas(String path){
        try{
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String sor = br.readLine();
            while (sor != null){
                String[] adatTag = sor.split(";");
                Bejegyzes bejegyzes = new Bejegyzes(adatTag[0], adatTag[1]);
                bejegyzesLista.add(bejegyzes);
                sor = br.readLine();
            }
            fr.close();
            br.close();
        }
        catch (IOException e){
            e.getMessage();
        }
    }

    public static void main(String[] args) {
        Bejegyzes b1 = new Bejegyzes("Ben Affleck", "Totalra nem tudom, mit keresek itt.");
        Bejegyzes b2 = new Bejegyzes("Jozska", "Utalom a beragado Shift billentyuket.");
        bejegyzesLista.add(b1);
        bejegyzesLista.add(b2);

        System.out.println("Köszöntelek! Ez a program egy portál bejegyzéseivel foglalkozik!");

        felhaszKiirat();
        fajlBeolvasas("bejegyzesek.txt");


    }
}
