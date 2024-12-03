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
        quadrat = new char[5][5];
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
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                quadrat[i][j] = alphabet.charAt(index++);
            }
        }
    }


    public void verschluesseln() {

    }


    public void entschluesseln() {

    }
}
