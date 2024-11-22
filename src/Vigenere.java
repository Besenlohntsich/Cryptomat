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


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vigenere vigenere = new Vigenere();
        int option;

        do {
            System.out.println("Wähle eine Option:");
            System.out.println("0 - Beenden");
            System.out.println("1 - Verschlüsseln");
            System.out.println("2 - Entschlüsseln");

            //verhindert crash durch eingabe einen falschen datentyps
            while (true) {
                try {
                    option = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Ungültige Eingabe. Bitte eine Zahl eingeben.");
                    sc.next();
                }
            }


            switch (option) {
                case 0:
                    //case wert wird mit option verglichen, wenn diese gleich sind...
                    System.out.println("Programm wird beendet.");
                    //Nachricht zum Informieren des benutzters
                    break;

                case 1:
                    //case wert wird mit option verglichen, wenn diese gleich sind...

                    System.out.println("Gebe eine Nachricht zum Verschlüsseln ein:");
                    vigenere.setKt(sc.nextLine());
                    //Kt wird gesetzt
                    System.out.print("Gebe den Buchstaben Schlüssel ein:");
                    vigenere.setS(sc.nextLine());
                    //s wird gesetzt


                    vigenere.verschluesseln();
                    System.out.println("Verschlüsselte Nachricht: " + vigenere.getGt());
                    //Ausgabe vom Ergebniss
                    break;
                case 2:
                    //case wert wird mit option verglichen, wenn diese gleich sind...

                    System.out.println("Gebe die verschlüsselte Nachricht ein:");
                    vigenere.setGt(sc.nextLine());
                    //gt wird gesetzt
                    System.out.print("Gebe den Buchstaben Schlüssel ein:");
                    vigenere.setS(sc.nextLine());
                    //s wird gesetzt

                    vigenere.entschluesseln();
                    System.out.println("Entschlüsselte Nachricht: " + vigenere.getKt());
                    //Ausgabe vom Ergebniss
                    break;
                default:
                    //wenn kein case zutrifft
                    System.out.println("Ungültige Option, bitte wähle erneut.");
                    //Nachricht zum Informieren des benutzters, dass er keine gültige option gewählt hat

            }
        } while (option != 0);
        //ruft alles unter dem do wieder auf, wenn option ungleich 0 ist
        sc.close();
        //beendung des Programms
    }
}
