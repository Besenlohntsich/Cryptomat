import java.util.InputMismatchException;
import java.util.Scanner;

public class Vigenere extends Kryptomat{

    public void verschluesseln() {

        String result = "";

        int schluesselLaenge = S.length();
        //Schlüssellänge des Schlüssels

        for (int i = 0; i < kt.length(); i++) {
            //Wir gehen durch den Array
            char Zs = Character.toUpperCase(S.charAt(i % schluesselLaenge));
            //Zs ist der schlüsselbuchstabe als zahl welcher
            // zyklisch wiederholt werden soll, wenn er kürzer ist als der zu verschlüsselnde Text

            char ch = Character.toUpperCase(kt.charAt(i));
            //buchstaben werden zuerst in Großbuchstaben verwandelt

            if (Character.isLetter(ch))
            //wenn es ein Buchstabe ist
            {
                ch = zahlenZuBuchstaben((buchstabenZuZahlen(ch) + buchstabenZuZahlen(Zs)) % 26);
                //Schlüssel wird durch die Zahl der Buchstaben addiert und mod 26 "begrentzt"
                // um Buchstaben zu nutzen die im Alphabet liegen
            }

            result += ch;
        }

        gt = result;
    }

    public void entschluesseln()
    {
        String result = "";

        int schluesselLaenge = S.length();
        //Schlüssellänge des Schlüssels

        for (int i = 0; i < gt.length(); i++) {
            //Wir gehen durch den Array
            char Zs = Character.toUpperCase(S.charAt(i % schluesselLaenge));
            //Zs ist der schlüsselbuchstabe als zahl welcher
            // zyklisch wiederholt werden soll, wenn er kürzer ist als der zu verschlüsselnde Text

            char ch = Character.toUpperCase(gt.charAt(i));
            //buchstaben werden zuerst in Großbuchstaben verwandelt

            if (Character.isLetter(ch))
            //wenn es ein Buchstabe ist
            {
                ch = zahlenZuBuchstaben((buchstabenZuZahlen(ch) - buchstabenZuZahlen(Zs)) % 26);
                //Schlüssel wird durch die Zahl der Buchstaben addiert und mod 26 "begrentzt"
                // um Buchstaben zu nutzen die im Alphabet liegen
            }


            result += ch;

        }

        kt = result;
    }

}
