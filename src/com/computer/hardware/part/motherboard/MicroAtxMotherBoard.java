package com.computer.hardware.part.motherboard;

import static java.lang.Math.abs;

public class MicroAtxMotherBoard extends MotherBoard {
    private final String atxMotherBoardId;
    private final String atxMotherBoardName;
    private final String config;
    private final double price;
    @Override
    public String toString() {
        return  this.getClass().getSuperclass().getSimpleName()+"\n"+"\n"+
                "MotherBoardId = " + atxMotherBoardId + "\n"+
                "MotherBoardName = "  + atxMotherBoardName + "\n"+
                "config=" + config + "\n";
    }

    public MicroAtxMotherBoard(String motherBoardName, String config, double price) {
        this.atxMotherBoardId = "MBMCATX-" + abs(this.hashCode());
        this.atxMotherBoardName = motherBoardName;
        this.config = config;
        this.price = price;
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
