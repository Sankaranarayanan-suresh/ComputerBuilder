package com.computer.software.os.mac;

import com.computer.hardware.part.motherboard.MotherBoard;
import com.computer.software.os.os.Os;
import com.computer.software.os.mac.application.Application;
import com.computer.software.os.mac.application.Calculator;
import com.computer.software.os.mac.application.GSearch;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Mac extends Os {
    private final String macOsId;
    private final String macOsName;
    private final String config;
    private final double price;
    private final List<Application> macApps = new ArrayList<>();

    public Mac(String macOsName, String config, double price, MotherBoard motherBoard) {
        super(motherBoard);
        this.macOsId = "OSMAC-" + abs(this.hashCode());
        this.macOsName = macOsName;
        this.config = config;
        this.price = price;
        this.macApps.add(new Calculator());
        this.macApps.add(new GSearch());
    }

    @Override
    public String toString() {
        return  this.getClass().getSuperclass().getSimpleName()+"\n"+"\n"+
                "OsId='" + macOsId + '\n' +
                "OsName='" + macOsName + '\n' +
                "config='" + config + '\n';
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
    public List<Application> getApplication() {
        return macApps;
    }

    public interface MacApps {

    }
}
