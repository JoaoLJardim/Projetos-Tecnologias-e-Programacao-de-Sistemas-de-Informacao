public class House extends Property {

    private boolean hasPool;
    private int floors;

    public House() {
        super();
        this.hasPool = false;
        this.floors = 0;
    }

    public House(Condition condition, int price, int year, int bedrooms, double area, Garage garage, int floors, boolean hasPool) {
        super(condition, price, year, bedrooms, area, garage);
        this.hasPool = hasPool;
        this.floors = floors;
    }


    public boolean isHasPool() {
        return hasPool;
    }

    public void setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "House{" +
                "hasPool=" + hasPool +
                ", floors=" + floors +
                ", " + super.toString() +
                '}';
    }
}
