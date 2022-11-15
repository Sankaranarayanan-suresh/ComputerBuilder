package com.computer.part.keyboard;

import com.computer.part.motherboard.MotherBoard;

public class Mechanical extends Keyboard {
    private static int MecKeyboardCounter = 0;
    private final String MecKeyboardId;
    private final String MecKeyboardName;
    private final String config;
    private final double price;

    public Mechanical(String keyboardName, String config, double price, MotherBoard motherBoard) {
        this.MecKeyboardId = "MEC/" + ++MecKeyboardCounter;
        this.MecKeyboardName = keyboardName;
        this.config = config;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Mechanical{" +
                "MecKeyboardId='" + MecKeyboardId + '\'' +
                ", MecKeyboardName='" + MecKeyboardName + '\'' +
                ", config='" + config + '\'' +
                '}';
    }

    @Override
    public String getType() {
        return "Mechanical";
    }

    @Override
    public String getName() {
        return MecKeyboardName;
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
        return MecKeyboardId;
    }
}
