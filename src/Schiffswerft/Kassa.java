package Schiffswerft;

import inout.them.fhb.at.InOut;

public class Kassa {
    private static double kassastand;
    //Fields of Kassa

    public Kassa(double anfangskapital) {
        kassastand = anfangskapital;
    }

    public static void lackierungZahlen(Schiff z) {
        // implement lackierungZahlen in Schiffswerft.Kassa
        if(z.schiffsart() == "Frachtschiff"){
            kassastand = kassastand - 1;
        }
        else if (z.schiffsart() == "Tankschiff"){
            kassastand = kassastand - 3;
        }
        else if (z.schiffsart() == "Passagierschiff"){
            kassastand = kassastand - 5;
        }
    }

    public void auszahlen(double betrag) throws KonkursException{
        //implement auszahlen in Schiffswerft.Kassa
        if(kassastand < betrag) throw new KonkursException();
        kassastand = kassastand - betrag;
    }

    public void einzahlen(double betrag) {
        kassastand = kassastand + betrag;
    }

    public void status() {
        InOut.printString("Kasastand: " + kassastand + " Millionen Euro ");
    }
    // implement body of Kassa
}
