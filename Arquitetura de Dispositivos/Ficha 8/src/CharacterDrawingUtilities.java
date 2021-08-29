public class CharacterDrawingUtilities {

    public static void drawElement(char element) {
        System.out.print(element);
    }

    public static void drawNewLine() {
        System.out.println();
    }

    public static void drawHorizontalSegmentWith(int i, char c) {
        for (int i1 = 0; i1 < i; i1++) {
            drawElement(c);
        }
    }

    public static void drawFilledRectangleWith(int altura, int largura, char c) {
        for (int i = 0; i < altura; i++) {
            drawHorizontalSegmentWith(largura,c);
            drawNewLine();
        }
    }

    public static void drawEmptyRectangleWith(int altura, int largura, char c) {
        for (int i = 1; i <= altura; i++) {
            if (i == 1 || i == altura) {
                for (int i1 = 0; i1 < largura; i1++) {
                    drawElement(c);
                }
            } else {
                for (int i1 = 0; i1 < largura; i1++) {
                    if (i1 == 0 || i1 == largura-2) {
                        drawElement(c);
                    }
                    drawElement(' ');
                }
            }
            drawNewLine();
        }
    }
}
