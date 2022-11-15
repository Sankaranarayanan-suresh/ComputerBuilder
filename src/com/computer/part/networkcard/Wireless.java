package com.computer.part.networkcard;

public class Wireless extends NetworkCard {
    private static int WiredCardCounter = 0;
    private boolean status;
    private String WiredCardId;
    private String WiredCardName;
    private String config;
    private double price;

    public Wireless(String WiredCardName, String config, double price) {
        this.WiredCardId = "NIC/" + ++WiredCardCounter;
        this.WiredCardName = WiredCardName;
        this.config = config;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Wireless{" +
                ", WiredCardId='" + WiredCardId + '\'' +
                ", WiredCardName='" + WiredCardName + '\'' +
                ", config='" + config + '\'' +
                '}';
    }

    @Override
    public String getType() {
        return "Wireless";
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
