package com.computer.part.keyboard;

import java.time.LocalTime;

import static java.lang.Math.abs;

public class Mechanical extends Keyboard {
    private final String MecKeyboardId;
    private final String MecKeyboardName;
    private final String config;
    private final double price;

    public Mechanical(String keyboardName, String config, double price) {
        this.MecKeyboardId = "KBMC-" + abs(this.hashCode());
        this.MecKeyboardName = keyboardName;
        this.config = config;
        this.price = price;
    }

    @Override
    public String toString() {
        return  "MecKeyboardId='" + MecKeyboardId + '\n' +
                "MecKeyboardName='" + MecKeyboardName + '\n' +
                "config='" + config + '\n';
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
