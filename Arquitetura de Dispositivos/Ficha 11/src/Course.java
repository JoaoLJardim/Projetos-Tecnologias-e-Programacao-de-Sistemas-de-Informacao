import java.util.Objects;

public class Course {

    private int code, ects,ano;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return code == course.code &&
                ects == course.ects &&
                ano == course.ano &&
                Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, ects, ano, name);
    }


}
