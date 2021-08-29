public class CaesarCipherDecipherer {

    public static String cipher(String str, int i) {
        String res = "";
        for (int j = 0; j < str.length(); j++) {
            char char2 = ' ';
            if (str.charAt(j) != ' ')
                char2 = CharacterUtilities.lowerLetterSuccessorStepsOf(str.charAt(j), i);
            res = res + char2;
        }
        return res;
    }

    public static String decipher(String str, int i) {
        str = str.toLowerCase();
        String res = "";
        for (int j = 0; j < str.length(); j++) {
            char char2 = ' ';
            if (str.charAt(j) != ' ')
                char2 = CharacterUtilities.lowerLetterPredecessorStepsOf(str.charAt(j), i);

            res = res + char2;
        }
        return res;
    }
}
