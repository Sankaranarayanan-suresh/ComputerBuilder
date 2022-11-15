package com.computer.part.networkcard;

public class Wired extends NetworkCard {
    private static int WiredCardCounter = 0;
    private String WiredCardId;
    private String WiredCardName;
    private String config;
    private boolean status;
    private double price;

    public Wired(String WiredCardName, String config, double price) {
        this.WiredCardId = "NIC/" + ++WiredCardCounter;
        this.WiredCardName = WiredCardName;
        this.config = config;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Wired{" +
                "WiredCardId='" + WiredCardId + '\'' +
                ", WiredCardName='" + WiredCardName + '\'' +
                ", config='" + config + '\'' +
                '}';
    }

    @Override
    public String getType() {
        return "Wired";
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
