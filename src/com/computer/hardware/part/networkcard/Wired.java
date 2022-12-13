package com.computer.hardware.part.networkcard;

import static java.lang.Math.abs;

public class Wired extends NetworkCard {
    private String WiredCardId;
    private String WiredCardName;
    private String config;
    private boolean status;
    private double price;

    public Wired(String WiredCardName, String config, double price) {
        this.WiredCardId = "NCWI-" + abs(this.hashCode());
        this.WiredCardName = WiredCardName;
        this.config = config;
        this.price = price;
    }

    @Override
    public String toString() {
        return  "WiredCardId='" + WiredCardId + '\n' +
                "WiredCardName='" + WiredCardName + '\n' +
                "config='" + config + '\n';
    }

    @Override
    public String getName() {
        return WiredCardName;
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
        return WiredCardId;
    }

    @Override
    public void updateStatus() {
        this.status = !this.status;
    }

    @Override
    public boolean status() {
        return status;
    }
}
