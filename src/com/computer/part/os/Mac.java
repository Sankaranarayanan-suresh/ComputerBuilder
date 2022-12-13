package com.computer.part.os;

import com.computer.part.motherboard.MotherBoard;

import static java.lang.Math.abs;

public class Mac extends Os {
    private final String macOsId;
    private final String macOsName;
    private final String config;
    private final double price;

    public Mac(String macOsName, String config, double price, MotherBoard motherBoard) {
        super(motherBoard);
        this.macOsId = "OSMAC-" + abs(this.hashCode());
        this.macOsName = macOsName;
        this.config = config;
        this.price = price;
    }

    @Override
    public String toString() {
        return  "macOsId='" + macOsId + '\n' +
                "macOsName='" + macOsName + '\n' +
                "config='" + config + '\n';
    }

    @Override
    public String getName() {
        return macOsName;
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
        return macOsId;
    }
}
