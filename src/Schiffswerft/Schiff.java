package Schiffswerft;

import inout.them.fhb.at.InOut;

public abstract class Schiff {

    private static int naechsteFreieSchiffsnummer = 1;
    private double rostFaktor;
    int schiffsnummer;
    private int lackierungen;


    public Schiff(){
        rostFaktor = 1.0;
        schiffsnummer = naechsteFreieSchiffsnummer;
        naechsteFreieSchiffsnummer ++;
        lackierungen = 0;
    }



    public abstract double preis() ;

    public abstract double monatsGewinn();

    public abstract double bergungskosten();

    public void faehrtEinenMonat() {
        rostFaktor = rostFaktor * 0.92;
    }

    public static void schiffLackieren(Schiff z) {
        //implement schiffLackieren in Schiffswerft.Schiff
        z.rostFaktor = 1 - (z.lackierungen * 0.05);
        z.lackierungen ++;
        Kassa.lackierungZahlen(z);
    }

    public boolean istGesunken() {
        return rostFaktor < 0.25;
    }

    public void status() {
        InOut.printString("Schiff " + schiffsnummer + " ist ein " + schiffsart() + " Rostfaktor ist: " + rostFaktor + " und wurde " + lackierungen + " mal neu gestrichen");
    }

    protected abstract String schiffsart();

}
