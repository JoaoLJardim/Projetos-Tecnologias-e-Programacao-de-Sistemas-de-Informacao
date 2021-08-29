public class Main {

    public static int[] studentsNumbers = {
            20035, 39312, 25342, 31432
    };

    public static String[] courseAcronyms = {"AD", "WEB-FE", "WEB-BE"};

    public static int[][] studentGrades = {
            {15, 18, 17},
            {18, 10, 11},
            {11, 13, 15},
            {10, 19, 16}
    };

    public static void main(String[] args) {
        int bestStudent = 0;
        float bestMedia = 0;
        for (int i = 0; i < studentsNumbers.length; i++) {
            float media = 0;
            System.out.println("Student: " + studentsNumbers[i] + " Grades:");
            int[] grade = studentGrades[i];
            for (int i1 = 0; i1 < grade.length; i1++) {
                media += grade[i1];
                System.out.println(courseAcronyms[i1] + " - " + grade[i1]);
            }
            media = (media / grade.length);
            System.out.println("Media: " + media);
            if (media > bestMedia) {
                bestMedia = media;
                bestStudent = i;
            }
            System.out.println("#############");
        }
        System.out.println("\nbest media " + bestMedia + " of student " + studentsNumbers[bestStudent]);
    }

    // Java Head First Design Patterns
}
