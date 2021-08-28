public class Apartment extends Property {

    private int floor;
    private boolean hasElevator;

    public Apartment() {
        super();
        this.floor = 0;
        this.hasElevator = false;
    }

    public Apartment(Condition condition, int price, int year, int bedrooms, double area, Garage garage, int floor, boolean hasElevator) {
        super(condition, price, year, bedrooms, area, garage);
        this.floor = floor;
        this.hasElevator = hasElevator;
    }


    public boolean isHasElevator() {
        return hasElevator;
    }

    public void setHasElevator(boolean hasElevator) {
        this.hasElevator = hasElevator;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "floor=" + floor +
                ", hasElevator=" + hasElevator +
                ", " + super.toString() +
                '}';
    }
}
