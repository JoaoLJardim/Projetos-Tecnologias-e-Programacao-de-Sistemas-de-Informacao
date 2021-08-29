import java.util.Comparator;

public class StudentComparatorByNumber implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getNumber() * o2.getNumber() - o1.getNumber() * o2.getNumber();
    }
}
