package com.computer.hardware.part.monitor;

import static java.lang.Math.abs;

public class OLed extends Monitor {
    private final String monitorId;
    private final String monitorName;
    private final String config;
    private final double price;

    @Override
    public String toString() {
        return this.getClass().getSuperclass().getSimpleName()+"\n"+"\n"+
                "monitorId='" + monitorId + '\n' +
                "monitorName='" + monitorName + '\n' +
                "config='" + config + '\n';
    }

    public OLed(String monitorName, String config, double price) {
        this.monitorId = "MNOLED-" + abs(this.hashCode());
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
}

