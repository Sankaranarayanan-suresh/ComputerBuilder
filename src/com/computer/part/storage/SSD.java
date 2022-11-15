package com.computer.part.storage;

public class SSD extends Storage {
    private static int SDDCounter = 0;
    private final String SDDId;
    private final String SDDName;
    private final String config;
    private final double price;

    public SSD(String SDDName, String config, double price) {
        this.SDDId = "SDD/" + ++SDDCounter;
        this.SDDName = SDDName;
        this.config = config;
        this.price = price;
    }

    @Override
    public String toString() {
        return "SSD{" +
                "SDDId='" + SDDId + '\'' +
                ", SDDName='" + SDDName + '\'' +
                ", config='" + config + '\'' +
                '}';
    }

    @Override
    public String getType() {
        return "SSD";
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
