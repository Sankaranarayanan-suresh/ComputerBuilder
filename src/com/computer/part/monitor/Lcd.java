package com.computer.part.monitor;

import static java.lang.Math.abs;

public class Lcd extends Monitor {
    private final String monitorId;
    private final String monitorName;
    private final String config;
    private final double price;

    @Override
    public String toString() {
        return  "monitorId='" + monitorId + '\n' +
                "monitorName='" + monitorName + '\n' +
                "config='" + config + '\n';
    }

    public Lcd(String monitorName, String config, double price) {
        this.monitorId = "MNLCD-" + abs(this.hashCode());
        this.monitorName = monitorName;
        this.config = config;
        this.price = price;
    }

    @Override
    public String getName() {
        return monitorName;
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
        return monitorId;
    }
}
