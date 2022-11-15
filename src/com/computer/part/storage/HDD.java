package com.computer.part.storage;

import com.computer.applications.Application;

import java.util.ArrayList;
import java.util.List;

public class HDD extends Storage {
    private static int HDDCounter = 0;
    private final String HDDId;
    private final String HDDName;
    private final String config;
    private final double price;
    private ArrayList<Application> applications = new ArrayList<Application>();

    public List returnLists() {
        return applications;
    }

    public HDD(String HDDName, String config, double price) {
        this.HDDId = "HDD/" + ++HDDCounter;
        this.HDDName = HDDName;
        this.config = config;
        this.price = price;
    }

    @Override
    public String toString() {
        return "HDD{" +
                "HDDId='" + HDDId + '\'' +
                ", HDDName='" + HDDName + '\'' +
                ", config='" + config + '\'' +
                '}';
    }

    public void addApplication(Application app) {
        applications.add(app);
    }

    @Override
    public String getType() {
        return "HDD";
    }

    @Override
    public String getName() {
        return HDDName;
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
        return HDDId;
    }
}
