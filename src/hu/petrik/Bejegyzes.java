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
}
