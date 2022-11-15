package com.computer.part.monitor;

public class Led extends Monitor {
    private static int monitorCounter = 0;
    private final String monitorId;
    private final String monitorName;
    private final String config;
    private final double price;

    @Override
    public String toString() {
        return "Led{" +
                ", monitorId='" + monitorId + '\'' +
                ", monitorName='" + monitorName + '\'' +
                ", config='" + config + '\'' +
                '}';
    }

    public Led(String monitorName, String config, double price) {
        this.monitorId = "LED/" + ++monitorCounter;
        this.monitorName = monitorName;
        this.config = config;
        this.price = price;
    }

    @Override
    public String getType() {
        return "Led";
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
