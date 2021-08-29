public class Main {

    public static void main(String[] args) {
        String str = "Ola todo";

        str = cipher(str, 1);
        System.out.println(str);
        str = dicipher(str, 1);
        System.out.println(str);
    }

    private static String cipher(String str, int i) {
        String res = "";
        for (int j = 0; j < str.length(); j++) {
            int code = str.charAt(j) + i;
            char char2 = (char) code;
            res = res + char2;
        }
        return res;
    }

    private static String dicipher(String str, int i) {
        String res = "";
        for (int j = 0; j < str.length(); j++) {
            int code = str.charAt(j) - i;
            char char2 = (char) code;
            res = res + char2;
        }
        return res;
    }

    public static void incrementFirstOF(int[] numbers) {
        numbers[0] = 5;
    }

    public static void increment(int number) {
        System.out.println(number);
        number++;
        System.out.println(number);
    }
}
