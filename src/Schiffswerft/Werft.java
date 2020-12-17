package Schiffswerft;

import inout.them.fhb.at.InOut;
import main.Definitions;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Werft {
    //Schiffsliste

    List<Schiff> dieSchiffe;
    Kassa dieKassa;


    public Werft(){
        //iniziaöisieren der werft,
        dieSchiffe = new ArrayList<>();
        dieKassa = new Kassa(Definitions.ANFANGSKAPITAL);
    }


    public void status() {
        // implement status in Schiffswerft.Werft
        dieKassa.status();
        for(Schiff x: dieSchiffe) x.status();
    }

    public void bezahlen(Schiff s) throws KonkursException {
        // implement bezahlen in Schiffswerft.Werft
        dieKassa.auszahlen(s.preis());
    }

    public void bauen(Schiff s) {
        //  implement bauen in Schiffswerft.Werft
        dieSchiffe.add(s);
    }

    public void faehrtEinenMonat() throws KonkursException {
        // implement faehrtEinenMonat in Schiffswerft.Werft

        for (Schiff s: dieSchiffe) {
            dieKassa.einzahlen(s.monatsGewinn());
            s.faehrtEinenMonat();
        }
        for (Schiff x: gesunkeneSchiffe()) {
            dieKassa.auszahlen(x.bergungskosten());
            dieSchiffe.remove(x);
        }
    }

    private List<Schiff> gesunkeneSchiffe() {
        List<Schiff> g = new ArrayList<Schiff>();
        for(Schiff x: dieSchiffe){
            if(x.istGesunken()) {
                g.add(x);
            }
        }
        return g;
    }

    public void verschrotten(int s) throws KonkursException {
        //SchiffsID wird ünbergeben
        //verschrotten kostet 1/10 des Schiffpreises
        //Tkassa muss die verschrottungskosten auszahlen

        Iterator<Schiff> it = dieSchiffe.iterator();
        while (it.hasNext()) {
            Schiff x = it.next();
            if (x.schiffsnummer == s)
                it.remove();
            dieKassa.auszahlen((0.1 * x.preis()));
        }
    }

    public void schiffentfernen(Schiff y) {
        dieSchiffe.remove(y);
    }

    public void lackieren(int s2) {
        // implement lackieren in Schiffswerft.Werft
        for(Schiff z: dieSchiffe){
            if(s2 == z.schiffsnummer){
                Schiff.schiffLackieren(z);
            }
        }
    }
}
