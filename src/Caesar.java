import java.util.InputMismatchException;
import java.util.Scanner;

public class Caesar extends Kryptomat
{

    public void verschluesseln() {

        String Zwischenergebniss = "";

        for (int i = 0; i < kt.length(); i++) {
            //geht durch den Array
            char ch = Character.toUpperCase(kt.charAt(i));
            //Alle buchstaben werden auf großbuchstaben gesetzt

            if (Character.isUpperCase(ch)) {
                //wenn es ein Großbuchstabe ist, wird dieser verschlüsselt, dadurch bleiben alle
                //Zahlen, Zeichen und so weiter einfach bestehen
                ch = zahlenZuBuchstaben((buchstabenZuZahlen(ch) + s) % 26);

                /*
                 *
                 * Das Modulo 26 sorgt dafür, dass sich der Index
                 * im Bereich von 0 bis 25 (also innerhalb des Alphabets) bleibt.
                 * Wenn der Index größer als 25 wird, fängt er wieder von 0 an
                 */
            }

            Zwischenergebniss += ch;
        }

        gt = Zwischenergebniss;
        //geheimtext wird gleich dem Zwischenergebniss gesetzt
    }


    /**
     * Die Methode entschluesseln() entschlüsselt den geheimen Text (gt) unter
     * Verwendung des Schlüssels (schluessel) nach der Caesar-Methode und
     * speichert das Ergebnis im Klartext (kt).
     */
    public void entschluesseln() {


        String Zwischenergebniss = "";
        //speichert das Zwischenergebniss

        for (int i = 0; i < gt.length(); i++) {
            char ch = Character.toUpperCase(gt.charAt(i));
          //Alle Buchstaben werden in großbuchstaben umgewandelt
            if (Character.isUpperCase(ch)) {
                //wenn es ein Großbuchstabe ist, wird dieser verschlüsselt, dadurch bleiben alle
                //Zahlen, Zeichen und so weiter einfach bestehen
                ch = zahlenZuBuchstaben((buchstabenZuZahlen(ch) - s + 26) % 26);

            }

            Zwischenergebniss += ch;
        }

        kt = Zwischenergebniss;
        //der klartext wird nach dem fertigen verschlüsseln gleich dem Zwischenergebniss
        // gesetzt
    }
}

