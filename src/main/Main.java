package main;

import Schiffswerft.*;
import inout.them.fhb.at.InOut;
import inout.them.fhb.at.InOutException;

import javax.swing.*;

import static java.awt.SystemColor.menu;

public class Main {

    public static void main(String[] args) throws InOutException {

        Werft dieWerft = new Werft();
        try {
            while (true) {

                //Status der Werft anzeigen
                dieWerft.status();

                int auswahl = InOut.readMenu("\n\nPlease choose an entry:",
                        " - Frachtschiff bauen@ - Tankschiff bauen@ - Passagierschiff bauen@ - Schiff verschrotten@ - Schiff lackieren@ - nichts tun@ - Spiel beenden");
                InOut.printString("\n\nSie haben " + auswahl + " gewählt");

                switch (auswahl) {
                    case 1:
                        // ein Frachtschiff bauen
                        Schiff f = new Frachtschiff();
                        dieWerft.bezahlen(f);
                        dieWerft.bauen(f);
                        break;
                    case 2:
                        // ein Tankschiff bauen
                        Schiff t = new Tankschiff();
                        dieWerft.bezahlen(t);
                        dieWerft.bauen(t);
                        break;
                    case 3:
                        //ein Passagierschiff bauen
                        Schiff p = new Passagierschiff();
                        dieWerft.bezahlen(p);
                        dieWerft.bauen(p);
                        break;
                    case 4:
                        //ein Schiff verschrotten
                        int s = InOut.readInt("Welches Schiff soll verschrottet werden?\nSchiffsnummer eingeben: ");
                        dieWerft.verschrotten(s);
                        break;
                    case 5:
                        // ein Schiff lackieren
                        int s2 = InOut.readInt("Welches Schiff soll lackiert werden?\nSchiffsnummer eingeben: ");
                        dieWerft.lackieren(s2);
                        break;
                    case 6:
                        // nichts tun
                        InOut.printString("Ein Monat ist vergangen, keine Option gewaehlt");
                        break;
                    case 7:
                        //Spiel beenden
                        throw new SpielEndeException();
                }
                //Schiffe fahren 1 Monat herum
                dieWerft.faehrtEinenMonat();

            }
        } catch (InOutException e) {
            InOut.printString("Ups..... something went wrong");
        } catch (SpielEndeException e) {
            InOut.printString("Spiel beendet");
        }catch (KonkursException e) {
            InOut.printString("Konkurs - Spiel beendet");

        }
    }
}
