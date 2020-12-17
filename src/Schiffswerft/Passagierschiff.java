package Schiffswerft;

import main.Definitions;

public class Passagierschiff extends Schiff {

    public Passagierschiff(){

    }

    public double preis() {
        // implement preis in Schiffswerft.Passagierschiff
        return Definitions.PASSAGIERSCHIFFSPREIS;
    }

    public double monatsGewinn() {
        // implement monatsGewinn in Schiffswerft.Passagierschiff
        return Definitions.PASSAGIERSCHIFFSGEWINN;
    }

    public double bergungskosten() {
        // implement bergungskosten in Schiffswerft.Passagierschiff
        return 5 * preis();
    }

    protected String schiffsart() {
        //implement schiffsart in Schiffswerft.Passagierschiff
        return "Passagierschiff";
    }


}
