package Vehicles;

public abstract class Vehicle {

    private int year;
    private String brand, model, color;
    private double price;

    public Vehicle() { }
    public Vehicle(final int year, final String brand, final String model, final double price, final String color) {
        this.year = year;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Year: " + getYear() + " Brand: "+ getBrand() +
                " Model:" + getModel() + " Color: " + getColor()
                + "Price" + getPrice();
    }
}
