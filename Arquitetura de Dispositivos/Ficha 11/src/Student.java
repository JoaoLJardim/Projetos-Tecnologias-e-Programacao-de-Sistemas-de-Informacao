import java.util.Objects;

public class Student implements Comparable<Student>{

    private int number;
    private String name;

    public Student() {

    }

    public Student(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return number == student.number &&
                Objects.equals(name, student.name);
    }

    @Override
    public int compareTo(Student o) {
        return hashCode() * o.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
