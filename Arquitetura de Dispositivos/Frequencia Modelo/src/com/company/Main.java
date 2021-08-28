package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        CPU cpu = new CPU(4, 64, 3000);
        MobileDevice device = new MobileDevice("Apple", "Iphone", 2018, "24AS",
                cpu);

        MobilePhone phone = new MobilePhone("Apple", "Iphone", 2016, "24AS",
                new CPU(8, 64, 4000), "Meo", "4G");

        Tablet tablet = new Tablet("Apple", "Iphone", 2015, "24AS",
                new CPU(2, 32, 1600), true);

        ArrayList<MobileDevice> devices = new ArrayList<MobileDevice>();
        devices.add(tablet);
        devices.add(phone);
        devices.add(device);

        for (MobileDevice mobileDevice : devices) {
            System.out.println(mobileDevice.toString());
        }

        Collections.sort(devices);

        for (MobileDevice mobileDevice : devices) {
            System.out.println(mobileDevice.toString());
        }



    }
}
