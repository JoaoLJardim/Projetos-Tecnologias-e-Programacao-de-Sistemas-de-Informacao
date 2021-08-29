public class Main {
    public static void main(String[] args) {
//        char c = 'z';
//        char[] c2 = {'a','b','c','d','e'};
//        char[] c3 = {'f','g','h','i','j'};
//        System.out.println(CharacterUtilities.lowerLetterSuccessorOf(c));
//        System.out.println(CharacterUtilities.lowerLetterPredecessorOf(c));
//        System.out.println(CharacterUtilities.lowerLetterSuccessorStepsOf(c,5));
//        System.out.println(CharacterUtilities.lowerLetterPredecessorStepsOf(c, 5));
//        System.out.println(CharacterUtilities.occurrencesOfCharacterIn(c2,c));
//        System.out.println(CharacterUtilities.replaceCharacterIn(c2,'a', 'z'));
//        System.out.println(CharacterUtilities.concatenationOf(c2,c3));
//        System.out.println(CharacterUtilities.copyOfPartOf(c2,1, 4));

        String str1 = CaesarCipherDecipherer.cipher("ola todo bem",6);
        System.out.println(str1);
        System.out.println(CaesarCipherDecipherer.decipher(str1,6));
    }
}
