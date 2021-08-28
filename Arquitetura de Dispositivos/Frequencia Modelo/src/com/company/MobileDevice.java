package com.company;

public class MobileDevice implements Comparable<MobileDevice> {

    private String brand, model, serialNumber;
    private int year;
    private CPU cpu;

    MobileDevice() {
        this.brand = "";
        this.model = "";
        this.serialNumber = "";
        this.year = 0;
        this.cpu = new CPU();
    }

    MobileDevice(String brand, String model, int year, String serialNumber, CPU cpu) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.serialNumber = serialNumber;
        this.cpu = cpu;
    }

    public String getBrand() {
        return brand;
    }

    public CPU getCpu() {
        return cpu;
    }

    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "MobileDevice{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", cpu='" + cpu + '\'' +
                '}';
    }

    @Override
    public int compareTo(MobileDevice other) {
        return other.getYear() - getYear();
    }
}
