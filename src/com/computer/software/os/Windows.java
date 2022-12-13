package com.computer.software.os;

import com.computer.hardware.part.motherboard.MotherBoard;

import static java.lang.Math.abs;

public class Windows extends Os {
    private final String WindowsOsId;
    private final String WindowsOsName;
    private final String config;
    private final double price;

    public Windows(String WindowsOsName, String config, double price, MotherBoard motherBoard) {
        super(motherBoard);
        this.WindowsOsId = "OSWIN-" + abs(this.hashCode());
        this.WindowsOsName = WindowsOsName;
        this.config = config;
        this.price = price;
    }

    @Override
    public String toString() {
        return  "WindowsOsId='" + WindowsOsId + '\n' +
                "WindowsOsName='" + WindowsOsName + '\n' +
                "config='" + config + '\n' ;
    }

    @Override
    public String getName() {
        return WindowsOsName;
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
        return WindowsOsId;
    }
}
