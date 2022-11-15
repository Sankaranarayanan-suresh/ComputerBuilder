package com.computer.part.os;

import com.computer.part.motherboard.MotherBoard;

public class Mac extends Os {
    private static int macOsCounter = 0;
    private final String macOsId;
    private final String macOsName;
    private final String config;
    private final double price;

    public Mac(String macOsName, String config, double price, MotherBoard motherBoard) {
        super(motherBoard);
        this.macOsId = "Mac/" + ++macOsCounter;
        this.macOsName = macOsName;
        this.config = config;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Mac{" +
                "macOsId='" + macOsId + '\'' +
                ", macOsName='" + macOsName + '\'' +
                ", config='" + config + '\'' +
                '}';
    }

    @Override
    public String getType() {
        return "Mac";
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
