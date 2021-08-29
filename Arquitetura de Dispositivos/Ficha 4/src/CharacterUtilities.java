public class CharacterUtilities {

    public static char lowerLetterSuccessorOf(char c) {
        int value = c;
        value++;
        if ((char) value > 'z')
            value = 'a';
        return (char) value;
    }

    public static char lowerLetterPredecessorOf(char c) {
        int value = c;
        value--;
        if ((char) value < 'a')
            value = 'z';
        return (char) value;
    }

    public static char lowerLetterSuccessorStepsOf(char c, int i) {
        int value = c;
        for (int j = 0; j < i; j++) {
            value = lowerLetterSuccessorOf((char) value);
        }
        return (char) value;
    }

    public static char lowerLetterPredecessorStepsOf(char c, int i) {
        int value = c;
        for (int j = 0; j < i; j++) {
            value = lowerLetterPredecessorOf((char) value);
        }
        return (char) value;
    }

    public static int occurrencesOfCharacterIn(char[] c2,char c) {
        int count = 0;
        for (char c1 : c2) {
            if (c1 == c)
                count++;
        }
        return count;
    }

    public static char[] replaceCharacterIn(char[] array, char c, char c2) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == c)
                array[i] = c2;
        }
        return array;
    }

    public static char[] concatenationOf(char[] c2, char[] c3) {
        int count = 0;
        char[] res = new char[c2.length + c3.length];
        for (char c : c2) {
            res[count] = c;
            count++;
        }
        for (char c : c3) {
            res[count] = c;
            count++;
        }

        return res;
    }

    public static char[] copyOfPartOf(char[] c2, int i, int i1) {
        int count = 0;
        char[] res = new char[c2.length];
        for (int i2 = i; i2 <= i1; i2++) {
            res[count] = c2[i2];
            count++;
        }
        return res;
    }
}
