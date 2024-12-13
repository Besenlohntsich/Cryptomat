import java.util.InputMismatchException;
import java.util.Scanner;

public class Verwaltung {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Polybius polybius = new Polybius();
        Vigenere vigenere = new Vigenere();
        Caesar caesar = new Caesar();
        Dual dual = new Dual();
        int option;

        //wähle einer der verschlüsselungsmethoden
        do {
            System.out.println("Wähle eine Verschlüsselungsmethode:");
            System.out.println("1 - Vigenere Verschlüsselung");
            System.out.println("2 - Caesar Verschlüsselung");
            System.out.println("3 - Polybius Verschlüsselung");
            System.out.println("4 - Dualverschlüsselung");
            System.out.println("0 - Beenden");

            // Eingabe einer gültigen Option wird abgefangen (muss nicht genutzt werden)
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
                    System.out.println("Programm wird beendet.");
                    break;
                case 1:
                    nutzeVigenere(sc, vigenere);
                    break;
                case 2:
                    nutzeCaesar(sc, caesar);
                    break;
                    case 3:nutzePolybius(sc, polybius);

                     case 4:nutzeDual(sc, dual);
                default:
                    System.out.println("Ungültige Option, bitte wähle erneut.");
            }
        } while (option != 0);

        sc.close();
    }

    private static void nutzeDual(Scanner sc, Dual dual) {
        System.out.println("Dual Verschlüsselung");
        System.out.println("1 - Verschlüsseln");
        System.out.println("2 - Entschlüsseln");

        int subOption = getValidOption(sc);

        switch (subOption) {
            case 1:
                System.out.println("Gebe eine Nachricht zum Verschlüsseln ein:");
                dual.setKt(sc.nextLine());
                System.out.print("Gebe den Zahlenschlüssel ein:");
                dual.setS(getValidIntegerInput(sc));
                dual.verschluesseln();
                System.out.println("Verschlüsselte Nachricht: " + dual.getGt());
                break;
            case 2:
                System.out.println("Gebe die verschlüsselte Nachricht ein:");
                dual.setGt(sc.nextLine());
                System.out.print("Gebe den Zahlenschlüssel ein:");
                dual.setS(getValidIntegerInput(sc));
                dual.entschluesseln();
                System.out.println("Entschlüsselte Nachricht: " + dual.getKt());
                break;
            default:
                System.out.println("Ungültige Option, zurück zum Hauptmenü.");
        }
    }

    private static void nutzePolybius(Scanner sc, Polybius polybius) {
        System.out.println("Vigenere Verschlüsselung");
        System.out.println("1 - Verschlüsseln");
        System.out.println("2 - Entschlüsseln");

        int subOption = getValidOption(sc);

        switch (subOption) {
            case 1:
                System.out.println("Gebe eine Nachricht zum Verschlüsseln ein:");
                polybius.setKt(sc.nextLine());

                polybius.verschluesseln();
                System.out.println("Verschlüsselte Nachricht: " + polybius.getGt());
                break;
            case 2:
                System.out.println("Gebe die verschlüsselte Nachricht ein:");
                polybius.setGt(sc.nextLine());
                
                polybius.entschluesseln();
                System.out.println("Entschlüsselte Nachricht: " + polybius.getKt());
                break;
            default:
                System.out.println("Ungültige Option, zurück zum Hauptmenü.");
        }
    }

    private static void nutzeVigenere(Scanner sc, Vigenere vigenere) {
        System.out.println("Vigenere Verschlüsselung");
        System.out.println("1 - Verschlüsseln");
        System.out.println("2 - Entschlüsseln");

        int subOption = getValidOption(sc);

        switch (subOption) {
            case 1:
                System.out.println("Gebe eine Nachricht zum Verschlüsseln ein:");
                vigenere.setKt(sc.nextLine());
                System.out.print("Gebe den Buchstaben Schlüssel ein:");
                vigenere.setS(sc.nextLine());
                vigenere.verschluesseln();
                System.out.println("Verschlüsselte Nachricht: " + vigenere.getGt());
                break;
            case 2:
                System.out.println("Gebe die verschlüsselte Nachricht ein:");
                vigenere.setGt(sc.nextLine());
                System.out.print("Gebe den Buchstaben Schlüssel ein:");
                vigenere.setS(sc.nextLine());
                vigenere.entschluesseln();
                System.out.println("Entschlüsselte Nachricht: " + vigenere.getKt());
                break;
            default:
                System.out.println("Ungültige Option, zurück zum Hauptmenü.");
        }
    }

    private static void nutzeCaesar(Scanner sc, Caesar caesar) {
        System.out.println("Caesar Verschlüsselung");
        System.out.println("1 - Verschlüsseln");
        System.out.println("2 - Entschlüsseln");

        int subOption = getValidOption(sc);

        switch (subOption) {
            case 1:
                System.out.println("Gebe eine Nachricht zum Verschlüsseln ein:");
                caesar.setKt(sc.nextLine());
                System.out.print("Gebe den Zahlenschlüssel ein:");
                caesar.setS(getValidIntegerInput(sc));
                caesar.verschluesseln();
                System.out.println("Verschlüsselte Nachricht: " + caesar.getGt());
                break;
            case 2:
                System.out.println("Gebe die verschlüsselte Nachricht ein:");
                caesar.setGt(sc.nextLine());
                System.out.print("Gebe den Zahlenschlüssel ein:");
                caesar.setS(getValidIntegerInput(sc));
                caesar.entschluesseln();
                System.out.println("Entschlüsselte Nachricht: " + caesar.getKt());
                break;
            default:
                System.out.println("Ungültige Option, zurück zum Hauptmenü.");
        }
    }


    /**
     * Die methoden sorgen dafür, dass ein falscher datentyp als eingabe nicht zum crash des programms führt
     * dabei wird erst versucht den input zu nutzen, wenn dieser eine InputMismatchException ist, dann wird
     * dieser abgefangen und man wird aufgefordert den korrekten datentyp zu nutzen.
     *
     */

    private static int getValidOption(Scanner sc) {
        while (true) {
            try {
                int option = sc.nextInt();
                sc.nextLine();
                return option;
            } catch (InputMismatchException e) {
                System.out.println("");
                sc.next();
            }
        }
    }

    private static int getValidIntegerInput(Scanner sc) {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("");
                sc.next();
            }
        }
    }
}