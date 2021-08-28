package com.company;

public class CPU {

    private int cores, bits, speed;

    CPU() {
        this.cores = 0;
        this.bits = 0;
        this.speed = 0;
    }

    CPU(int cores, int bits, int speed) {
        this.cores = cores;
        this.bits = bits;
        this.speed = speed;
    }

    public int getBits() {
        return bits;
    }

    public int getCores() {
        return cores;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "cores=" + cores +
                ", bits=" + bits +
                ", speed=" + speed +
                '}';
    }
}
