public class Dual extends Kryptomat {

    private char[][] binaerArray;
    public void verschluesseln() {
        if (kt == null || kt.isEmpty()) {
            gt = "";
            return;
        }

        // Initialisiere das 2D array
        binaerArray = new char[kt.length()][7];

        // Convert each character to binary and store in the 2D array
        for (int i = 0; i < kt.length(); i++) {
            char c = kt.charAt(i);
            int asciiValue = (int) c;

            /*
            asciiValue % 2 gives the remainder when divided by 2.
            If the remainder is 0, the current bit is '0'; otherwise, it's '1'.
            This binary digit is stored in the binaerArray at position [i][j].
          */
            for (int j = 6; j >= 0; j--) {
                binaerArray[i][j] = (asciiValue % 2 == 0) ? '0' : '1';
                asciiValue /= 2;
            }
        }

        // Convert binary array to encrypted text
        gt = "";
        for (int i = 0; i < kt.length(); i++) {
            for (int j = 0; j < 7; j++) {
                gt += binaerArray[i][j];
            }
            if (i < kt.length() - 1) {
                gt += "\n";
            }
        }
    }



    public void entschluesseln() {

    }
}
