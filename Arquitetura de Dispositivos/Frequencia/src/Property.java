public class Property {
    private Condition condition;
    private int price;
    private int year;
    private int bedrooms;
    private double area;
    private Garage garage;


    public Property() {
        this.condition = Condition.NEW;
        this.price = 0;
        this.year = 0;
        this.bedrooms = 0;
        this.area = 0;
        this.garage = new Garage();
    }


    public Property (Condition condition, int price, int year, int bedrooms, double area, Garage garage) {
        this.condition = condition;
        this.price = price;
        this.year = year;
        this.bedrooms = bedrooms;
        this.area = area;
        this.garage = garage;
    }


    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    @Override
    public String toString() {
        return "Property{" +
                "condition=" + condition +
                ", price=" + price +
                ", year=" + year +
                ", bedrooms=" + bedrooms +
                ", area=" + area +
                ", garage=" + garage +
                '}';
    }
}
