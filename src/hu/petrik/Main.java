package hu.petrik;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Bejegyzes> bejegyzesLista = new ArrayList<>();
    public static ArrayList<Bejegyzes> rendezettBejegyzesLista = new ArrayList<>();

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

    public static void likeOszto(){
        int osztandoLikeokSzama = bejegyzesLista.size() * 20;

        for (int i = 0; i < osztandoLikeokSzama; i++) {
            double veletlen = Math.random() * bejegyzesLista.size();
            bejegyzesLista.get((int)(veletlen)).like();
        }
    }

    public static void bejegyzes2Modosit(){
        System.out.println("Módosítsd a 2. bejegyzés tartalmát!");
        String tartalomModositott = sc.nextLine();
        bejegyzesLista.get(1).setTartalom(tartalomModositott);
    }


    public static void legnepszerubbBejegyzes(){
        int legtobbLike = bejegyzesLista.get(0).getLikeok();
        for (Bejegyzes elem: bejegyzesLista) {
            if (elem.getLikeok() > legtobbLike){
                legtobbLike = elem.getLikeok();
            }
        }
        System.out.println("A legnépszerűbb bejegyzés like-jainak száma: " + legtobbLike);
    }

    public static void vanE35nelTobb(){
        boolean vanE = false;
        for (Bejegyzes elem: bejegyzesLista) {
            if (elem.getLikeok() > 35){
                vanE = true;
            }
            else{
                vanE = false;
            }
        }
        if (vanE){
            System.out.println("Van olyan bejegyzes, ami 35-nél több like-ot kapott.");
        }
        else{
            System.out.println("Nincsen olyan bejegyzes, ami 35-nél több like-ot kapott.");
        }
    }

    public static void kevesebbMint15Like(){
        int dbSzam = 0;
        for (Bejegyzes elem: bejegyzesLista) {
            if (elem.getLikeok() < 15){
                dbSzam += 1;
            }
        }
        System.out.println("A 15 like-nál kevesebbel rendelkező bejegyzések száma: " + dbSzam);
    }

    public static void atrendezesLikeokSzerint(){
        /*int legtobbLike = legnepszerubbBejegyzes();
        Bejegyzes legtobbLike = bejegyzesLista.get(legnepszerubbBejegyzes(););*/
    }


    public static void main(String[] args) {
        Bejegyzes b1 = new Bejegyzes("Ben Affleck", "Totalra nem tudom, mit keresek itt.");
        Bejegyzes b2 = new Bejegyzes("Jozska", "Utalom a beragado Shift billentyuket.");
        bejegyzesLista.add(b1);
        bejegyzesLista.add(b2);

        System.out.println("Köszöntelek! Ez a program egy portál bejegyzéseivel foglalkozik!");

        felhaszKiirat();
        fajlBeolvasas("bejegyzesek.txt");
        likeOszto();
        bejegyzes2Modosit();

        for (Bejegyzes elem: bejegyzesLista) {
            System.out.println(elem);
        }
        System.out.println("\n");


        legnepszerubbBejegyzes();
        vanE35nelTobb();
        kevesebbMint15Like();


    }
}
