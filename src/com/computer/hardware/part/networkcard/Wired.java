package com.computer.hardware.part.networkcard;

import static java.lang.Math.abs;

public class Wired extends NetworkCard {
    private final String WiredCardId;
    private final String WiredCardName;
    private final String config;
    private boolean status;
    private final double price;

    public Wired(String WiredCardName, String config, double price) {
        this.WiredCardId = "NCWI-" + abs(this.hashCode());
        this.WiredCardName = WiredCardName;
        this.config = config;
        this.price = price;
    }

    @Override
    public String toString() {
        return  this.getClass().getSuperclass().getSimpleName()+"\n"+"\n"+
                "NetworkCardId='" + WiredCardId + '\n' +
                "NetworkCardName='" + WiredCardName + '\n' +
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
    public void toggleStatus() {
        this.status = !this.status;
    }

    @Override
    public boolean status() {
        return status;
    }
}
