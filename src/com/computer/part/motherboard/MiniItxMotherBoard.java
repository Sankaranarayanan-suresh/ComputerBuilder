package com.computer.part.motherboard;

public class MiniItxMotherBoard extends MotherBoard {
    private static int atxMotherBoardCounter = 0;
    private final String atxMotherBoardId;
    private final String atxMotherBoardName;
    private final String config;
    private final double price;

    public MiniItxMotherBoard(String motherBoardName, String config, double price) {
        this.atxMotherBoardId = "MINIATX/" + ++atxMotherBoardCounter;
        ;
        this.atxMotherBoardName = motherBoardName;
        this.config = config;
        this.price = price;
    }

    @Override
    public String toString() {
        return "MiniItxMotherBoard{" +
                "atxMotherBoardId='" + atxMotherBoardId + '\'' +
                ", atxMotherBoardName='" + atxMotherBoardName + '\'' +
                ", config='" + config + '\'' +
                '}';
    }

    @Override
    public String getType() {
        return "MiniItxMotherBoard";
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
