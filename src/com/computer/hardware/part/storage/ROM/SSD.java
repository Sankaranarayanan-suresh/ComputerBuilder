package com.computer.hardware.part.storage.ROM;

import com.computer.software.application.Application;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class SSD extends ROM {
    private final String SDDId;
    private final String SDDName;
    private final String config;
    private final double price;
    private ArrayList<Application> applications = new ArrayList<>();


    public SSD(String SDDName, String config, double price) {
        this.SDDId = "ROMSDD-" + abs(this.hashCode());
        this.SDDName = SDDName;
        this.config = config;
        this.price = price;
    }
    public void addApplication(Application app) {
        applications.add(app);
    }

    public List returnLists() {
        return applications;
    }
    @Override
    public String toString() {
        return  "SDDId='" + SDDId + '\n' +
                "SDDName='" + SDDName + '\n' +
                "config='" + config + '\n';
    }

    @Override
    public String getName() {
        return SDDName;
    }

    @Override
    public String getConfig() {
        return config;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getId() {
        return SDDId;
    }
}
