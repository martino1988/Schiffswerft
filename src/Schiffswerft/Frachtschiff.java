package Schiffswerft;

import main.Definitions;

public class Frachtschiff extends Schiff {

    public Frachtschiff(){

    }

    public double preis() {
        // implement preis in Schiffswerft.Frachtschiff
        return Definitions.FRACHTSCHIFFSPREIS;
    }

    public double monatsGewinn() {
        // implement monatsGewinn in Schiffswerft.Frachtschiff
        return Definitions.FRACHTSCHIFFSGEWINN;
    }

    public double bergungskosten() {
        // implement bergungskosten in Schiffswerft.Frachtschiff
        return 5 * preis();
    }

    protected String schiffsart() {
        // implement schiffsart in Schiffswerft.Frachtschiff
        return "Frachtschiff";
    }


}
