package com.company;

public class Tablet extends MobileDevice {

    private boolean supportPen;

    Tablet() {
        super();
        this.supportPen = false;
    }

    public Tablet(String brand, String model, int year, String serialNumber, CPU cpu, boolean supportPen) {
        super(brand, model, year, serialNumber, cpu);
        this.supportPen = supportPen;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "supportPen=" + supportPen +
                '}';
    }
}
