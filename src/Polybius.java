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

    /**
     * Verschlüsselt den Klartext nach der Polybius-Methode.
     * Jeder Buchstabe wird durch seine Position im Quadrat (Zeile und Spalte) ersetzt.
     */
    public void verschluesseln() {
        String ergebnis = "";
        for (int l = 0; l < kt.length(); l++) {
            char c = Character.toUpperCase(kt.charAt(l));
            if (Character.isLetter(c)) {
                if (c == 'J') c = 'I'; // J wird als I behandelt
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (quadrat[i][j] == c) {   //wenn der buchstabe im quadrat gleich c ist dann speichert man die koordinate
                            ergebnis += i * 10 + 11 + j; // i wird mal 10 genommen damit die zahlen dem koordinaten entsprechen
                            break;
                        }
                    }
                }
            } else { //wenn das zeichen kein buchstabe ist, wird es einfach übernommen
                ergebnis += c;
            }
        }
        gt = ergebnis;

    }

    public void entschluesseln() {



        String ergebnis = "";
        for (int l = 0; l < gt.length(); l ++) //geht durch den kt array
        {
            if (Character.isDigit(gt.charAt(l))) {
                if (l + 1 < gt.length()) { //wenn es mehr als 2 zeichen gibt dann kann man entschlüssel, da wir ja 2 zahlen brauchen
                    int i = gt.charAt(l) - '1'; //der wert i wird = der z.b. ersten zahl gestzt und minus 1 damit es bei 0 beginnt
                    int j = gt.charAt(l + 1) - '1'; //der wert j wird = der z.b. zweiten zahl gestzt und minus 1 damit es bei 0 beginnt

                    if (i >= 0 && i < 5 && j >= 0 && j < 5) //wenn i und j im quadrat liegen
                    {
                        ergebnis += quadrat[i][j]; //übernehme den Buchstaben an der Koordinate

                    } else {   //wenn die bedingung nicht erfüllt wird, übernehme die Zeichen einfach
                        ergebnis += gt.charAt(l);
                        ergebnis += gt.charAt(l+1);
                    }
                    l++; // sorgt dafür das wir eine zahl überspringen da wir immer paare von zahlen nutzen

                }
            } else {
                ergebnis += gt.charAt(l);
                //übernimmt da zeichen einfach, wenn es keine zahl ist, dadurch werden
                // leerzeichen nicht mehr zu einem problem, weil normalerweise die paare durcheinander geraten
            }


            kt = ergebnis;

        }
    }

}

