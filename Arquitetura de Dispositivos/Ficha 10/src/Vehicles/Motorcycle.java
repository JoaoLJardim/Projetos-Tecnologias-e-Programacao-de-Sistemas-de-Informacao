package Vehicles;

public class Motorcycle extends Vehicle{

    public Motorcycle() {

    }

    public Motorcycle(final int year, final String brand, final String model, final double price, final String color) {
        super.setYear(year);
        super.setBrand(brand);
        super.setModel(model);
        super.setPrice(price);
        super.setColor(color);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
