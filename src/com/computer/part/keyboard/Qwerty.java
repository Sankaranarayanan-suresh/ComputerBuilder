package com.computer.part.keyboard;

public class Qwerty extends Keyboard {
    private static int QwertyKeyboardCounter = 0;
    private final String QwertyKeyboardId;
    private final String QwertyKeyboardName;
    private final String config;
    private final double price;

    public Qwerty(String keyboardName, String config, double price) {
        this.QwertyKeyboardId = "QWERTY/" + ++QwertyKeyboardCounter;
        this.QwertyKeyboardName = keyboardName;
        this.config = config;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Qwerty{" +
                "QwertyKeyboardId='" + QwertyKeyboardId + '\'' +
                ", QwertyKeyboardName='" + QwertyKeyboardName + '\'' +
                ", config='" + config + '\'' +
                '}';
    }

    @Override
    public String getType() {
        return "Qwerty";
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
