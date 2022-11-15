package com.computer.part.motherboard;

public class AtxMotherBoard extends MotherBoard {
    private static int atxMotherBoardCounter = 0;
    private final String atxMotherBoardId;
    private final String atxMotherBoardName;
    private final String config;
    private final double price;

    @Override
    public String toString() {
        return "AtxMotherBoard{" +
                ", atxMotherBoardId='" + atxMotherBoardId + '\'' +
                ", atxMotherBoardName='" + atxMotherBoardName + '\'' +
                ", config='" + config + '\'' +
                '}';
    }

    public AtxMotherBoard(String motherBoardName, String config, double price) {
        this.atxMotherBoardId = "ATX/" + ++atxMotherBoardCounter;
        this.atxMotherBoardName = motherBoardName;
        this.config = config;
        this.price = price;
    }

    @Override
    public String getType() {
        return this.getClass().getName();
    }

    @Override
    public String getName() {
        return atxMotherBoardName;
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
        return atxMotherBoardId;
    }
}
