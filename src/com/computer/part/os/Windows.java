package com.computer.part.os;

import com.computer.part.motherboard.MotherBoard;

public class Windows extends Os {
    private static int WindowsOsCount = 0;
    private final String WindowsOsId;
    private final String WindowsOsName;
    private final String config;
    private final double price;

    public Windows(String WindowsOsName, String config, double price, MotherBoard motherBoard) {
        super(motherBoard);
        this.WindowsOsId = "Windows/" + ++WindowsOsCount;
        this.WindowsOsName = WindowsOsName;
        this.config = config;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Windows{" +
                "WindowsOsId='" + WindowsOsId + '\'' +
                ", WindowsOsName='" + WindowsOsName + '\'' +
                ", config='" + config + '\'' +
                '}';
    }

    @Override
    public String getType() {
        return "Windows";
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
