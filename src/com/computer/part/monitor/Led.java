package com.computer.part.monitor;

import static java.lang.Math.abs;

public class Led extends Monitor {
    private final String monitorId;
    private final String monitorName;
    private final String config;
    private final double price;

    @Override
    public String toString() {
        return  "monitorId=" + monitorId + '\n' +
                "monitorName=" + monitorName + '\n' +
                "config=" + config + '\n';
    }

    public Led(String monitorName, String config, double price) {
        this.monitorId = "MNLED-" + abs(this.hashCode());
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
