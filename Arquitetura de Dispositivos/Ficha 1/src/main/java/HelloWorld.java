public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("O Perimetro do retângulo e: " + calcularPerimetro(1, 2));
        System.out.println("O Volume do paralelepípedo e: " + calcularVolume(7, 6, 2));
        System.out.println("Celsius: " + calcularCelcio(200));
        System.out.println("Os Segundos: " + calcularSegundos(2, 1, 5));

        System.out.println("Maximo: " + maximo(new int[]{2, 1, 56, 78, 9}));
        System.out.println("Minimo: " + minimo(new int[]{6, 125, 2, 5, 6}));
        System.out.println("Media: " + media(new int[]{2, 1, 7, 2, 7}));
    }

    public static int calcularPerimetro(int base, int altura) {
        return base * altura;
    }

    public static int calcularVolume(int comprimento, int altura, int largura) {
        return comprimento * largura * altura;
    }

    public static int calcularCelcio(int farenheit) {
        return (farenheit - 32) * 5 / 9;
    }

    public static int calcularSegundos(int hora, int minuto, int segundos) {
        int n = hora * 3600;
        n = n + minuto * 60;
        n = n + segundos;
        return n;
    }

    public static int maximo(int[] nums) {
        int res = nums[0];
        for (int num : nums) {
            if (num > res)
                res = num;
        }
        return res;
    }

    public static int minimo(int[] nums) {
        int res = nums[0];
        for (int num : nums) {
            if (num < res)
                res = num;
        }
        return res;
    }

    public static int media(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res + num;
        }
        return res / nums.length;
    }
}
