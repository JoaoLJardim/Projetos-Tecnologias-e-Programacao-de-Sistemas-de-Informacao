public class Employee  extends Object{
    private String name;
    private String ssn;

    public Employee(final String name, final String ssn) {
        this.name = name;
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "(" + getName() + ", " + getSsn() + ")";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}
