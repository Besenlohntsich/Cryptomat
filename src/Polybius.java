public class Polybius extends Kryptomat {

    /**
     * Das Polybius-Quadrat. repräsentiert als 5x5 char-Array.
     * Jede Zelle enthält einen Buchstaben des Alphabets (außer J, das durch I ersetzt wird).
     */
    private char[][] quadrat;


    /**
     * Konstruktor für die Polybius-Klasse.
     * Initialisiert das Polybius-Quadrat und füllt es mit Buchstaben.
     */
    public Polybius() {
        quadrat = new char[6][6];
        initialisiereQuadrat();
    }

    /**
     * Initialisiert das Polybius-Quadrat mit Buchstaben des Alphabets.
     * Die Buchstaben werden in alphabetischer Reihenfolge eingefügt,
     * wobei I und J als ein Buchstabe behandelt werden.
     */

    private void initialisiereQuadrat() {
        String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ"; //  I und J sind zusammengefasst
        int index = 0;
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                quadrat[i][j] = alphabet.charAt(index++);
            }
        }
    }

    /**
     * Verschlüsselt den Klartext nach der Polybius-Methode.
     * Jeder Buchstabe wird durch seine Position im Quadrat (Zeile und Spalte) ersetzt.
     */
    public void verschluesseln()
    {
        String ergebnis = "";
        for (int l = 0; l < kt.length(); l++) {
            char c = Character.toUpperCase(kt.charAt(l));
            if (Character.isLetter(c)) {
                if (c == 'J') c = 'I'; // J wird als I behandelt
                for (int i = 1; i < 6; i++) {
                    for (int j = 1; j < 6; j++) {
                        if (quadrat[i][j] == c) {   //wenn der buchstabe im quadrat gleich c ist dann speichert man die koordinate
                            ergebnis += i*10 + j; // i wird mal 10 genommen damit die zahlen dem koordinaten entsprechen
                            break;
                        }
                    }
                }
            } else {
                ergebnis += c;
            }
        }
        gt = ergebnis;

    }
        public void entschluesseln() {
            String ergebnis = "";
kt = ergebnis;
        }
    }

