package hu.petrik;

import java.time.LocalDateTime;

public class Bejegyzes {

    private String szerzo;
    private String tartalom;
    private int likeok = 0;
    private LocalDateTime letrejott = LocalDateTime.now();
    private LocalDateTime szerkesztve = LocalDateTime.now();

    public Bejegyzes(String szerzo, String tartalom){
        this.szerzo = szerzo;
        this.tartalom = tartalom;
    }

    public String getSzerzo() {
        return this.szerzo;
    }

    public String getTartalom() {
        return this.tartalom;
    }

    public void setTartalom(String tartalom) {
        this.tartalom = tartalom;
        szerkesztve = LocalDateTime.now();
    }

    public int getLikeok() {
        return this.likeok;
    }

    public LocalDateTime getLetrejott() {
        return this.letrejott;
    }

    public LocalDateTime getSzerkesztve() {
        return this.szerkesztve;
    }

    public void like(){
        likeok += 1;
    }
}
