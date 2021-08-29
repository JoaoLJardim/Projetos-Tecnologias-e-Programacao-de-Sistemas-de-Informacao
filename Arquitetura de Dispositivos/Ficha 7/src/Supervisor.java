public class Supervisor extends Employee {

    private int level;

    public Supervisor(final String name, final String ssn, final int level) {
        super(name, ssn);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "(" + getName() + ", " + getSsn() + "," + getLevel() + ")";
    }
}
