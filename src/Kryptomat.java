import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Kryptomat {

    protected String gt; // verschlüsselter Text
    protected String kt; // Klartext
    protected int s;
    protected String S;
    /**
     * Der Konstruktor initialisiert den Klartext und Geheimtext mit leeren Strings
     * und den Schlüssel mit 0.
     */
    public Kryptomat() {
        this.gt = "";
        this.kt = "";
        this.s = 0;
        this.S = "";
    }

    /**
     * Die Methode verschluesseln() verschlüsselt den Klartext (kt) unter
     * Verwendung des Schlüssels (s) nach der Kryptomat-Methode und
     * speichert das Ergebnis im geheimen Text (gt).
     */
    public abstract void verschluesseln();

    /**
     * Die Methode entschluesseln() entschlüsselt den geheimen Text (gt) unter
     * Verwendung des Schlüssels (schluessel) nach der Kryptomat-Methode und
     * speichert das Ergebnis im Klartext (kt).
     */
    public abstract void entschluesseln();

    /**
     * Methode zur Umwandlung eines Zahlenwerts in den entsprechenden Buchstaben
     *
     * @param pWert der Zahlenwert (Alphabet Index 0=A 1=B...)
     * @return der entsprechende Buchstabe
     */
    protected char zahlenZuBuchstaben(int pWert) {
        return (char) (pWert + 'A');
    }

    protected int buchstabenZuZahlen(char pWert) {
        return pWert - 'A';
    }

    // Getter und Setter Methoden

    public String getGt() {
        return gt;
    }

    public void setGt(String pGt) {
        gt = pGt;
    }

    public String getKt() {
        return kt;
    }

    public void setKt(String pKt) {
        kt = pKt;
    }

    public int gets() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }
    public String getS() {
        return S;
    }

    public void setS(String S) {
        this.S = S;
    }
}