package com.computer.part.networkcard;

import static java.lang.Math.abs;

public class Wireless extends NetworkCard {
    private boolean status;
    private String WiredCardId;
    private String WiredCardName;
    private String config;
    private double price;

    public Wireless(String WiredCardName, String config, double price) {
        this.WiredCardId = "NCWL-" + abs(this.hashCode());
        this.WiredCardName = WiredCardName;
        this.config = config;
        this.price = price;
    }

    @Override
    public String toString() {
        return  "WiredCardId='" + WiredCardId + '\n' +
                "WiredCardName='" + WiredCardName + '\n' +
                "config='" + config + '\n' ;
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
        this.status = true;
    }

    @Override
    public boolean status() {
        return status;
    }
}
