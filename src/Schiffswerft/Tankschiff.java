package Schiffswerft;

import main.Definitions;

public class Tankschiff extends Schiff {

    public Tankschiff(){

    }

    public double preis() {
        // implement preis in Schiffswerft.Tankschiff
        return Definitions.TANKSCHIFFSPREIS;
    }

    public double monatsGewinn() {
        // implement monatsGewinn in Schiffswerft.Tankschiff
        return Definitions.TANKSCHIFFGEWINN;
    }

    public double bergungskosten() {
        // implement bergungskosten in Schiffswerft.Tankschiff
        return 5 * preis();
    }

    protected String schiffsart() {
        // implement schiffsart in Schiffswerft.Tankschiff
        return "Tankschiff";
    }


}
