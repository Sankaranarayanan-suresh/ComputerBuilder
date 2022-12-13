package com.computer.part.keyboard;

import java.time.LocalTime;

import static java.lang.Math.abs;

public class Qwerty extends Keyboard {
    private final String QwertyKeyboardId;
    private final String QwertyKeyboardName;
    private final String config;
    private final double price;
    public Qwerty(String keyboardName, String config, double price) {
        this.QwertyKeyboardId = "KBQW-" + abs(this.hashCode()) ;
        this.QwertyKeyboardName = keyboardName;
        this.config = config;
        this.price = price;
    }

    @Override
    public String toString() {
        return  "QwertyKeyboardId='" + QwertyKeyboardId + '\n' +
                "QwertyKeyboardName='" + QwertyKeyboardName + '\n' +
                "config='" + config + '\n';
    }

    @Override
    public String getName() {
        return QwertyKeyboardName;
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
        return QwertyKeyboardId;
    }
}
