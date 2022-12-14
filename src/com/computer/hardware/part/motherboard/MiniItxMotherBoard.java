package com.computer.hardware.part.motherboard;

import static java.lang.Math.abs;

public class MiniItxMotherBoard extends MotherBoard {
    private final String atxMotherBoardId;
    private final String atxMotherBoardName;
    private final String config;
    private final double price;
    public MiniItxMotherBoard(String motherBoardName, String config, double price) {
        this.atxMotherBoardId = "MBMNATX-" + abs(this.hashCode());
        this.atxMotherBoardName = motherBoardName;
        this.config = config;
        this.price = price;
    }

    @Override
    public String toString() {
        return  this.getClass().getSuperclass().getSimpleName()+"\n"+"\n"+
                "MotherBoardId='" + atxMotherBoardId + '\n' +
                "MotherBoardName='" + atxMotherBoardName + '\n' +
                "config='" + config + '\n';
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

}
