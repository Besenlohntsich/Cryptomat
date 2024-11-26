import java.util.InputMismatchException;
import java.util.Scanner;

public class Caesar extends Kryptomat
{

    public void verschluesseln() {

        String result = "";

        for (int i = 0; i < kt.length(); i++) {
            char ch = Character.toUpperCase(kt.charAt(i));

            if (Character.isUpperCase(ch)) {
                ch = zahlenZuBuchstaben((buchstabenZuZahlen(ch) + s) % 26);

                /*
                 *
                 * Das Modulo 26 sorgt dafür, dass sich der Index
                 * im Bereich von 0 bis 25 (also innerhalb des Alphabets) bleibt.
                 * Wenn der Index größer als 25 wird, fängt er wieder von 0 an
                 */
            }

            result += ch;
        }

        gt = result;
    }


    /**
     * Die Methode entschluesseln() entschlüsselt den geheimen Text (gt) unter
     * Verwendung des Schlüssels (schluessel) nach der Caesar-Methode und
     * speichert das Ergebnis im Klartext (kt).
     */
    public void entschluesseln() {


        String result = "";

        for (int i = 0; i < gt.length(); i++) {
            char ch = Character.toUpperCase(gt.charAt(i));


            if (Character.isUpperCase(ch)) {
                ch = zahlenZuBuchstaben((buchstabenZuZahlen(ch) - s + 26) % 26);
            }

            result += ch;
        }

        kt = result;
    }
}

