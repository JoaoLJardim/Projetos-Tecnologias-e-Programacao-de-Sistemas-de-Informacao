public class Garage {
    private double area;
    private int capacity;
    private boolean automated;

    public Garage () {
        this.area = 0;
        this.capacity = 0;
        this.automated = false;
    }

    public Garage(double area, int capacity, boolean automated) {
        this.area = area;
        this.capacity = capacity;
        this.automated = automated;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isAutomated() {
        return automated;
    }

    public void setAutomated(boolean automated) {
        this.automated = automated;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "area=" + area +
                ", capacity=" + capacity +
                ", automated=" + automated +
                '}';
    }
}
