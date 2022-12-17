package com.computer.software.os.windows;

import com.computer.hardware.part.motherboard.MotherBoard;
import com.computer.software.os.os.Os;
import com.computer.software.os.mac.application.Application;
import com.computer.software.os.windows.bankapplication.BankApp;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Windows extends Os {
    private final String WindowsOsId;
    private final String WindowsOsName;
    private final String config;
    private final double price;
    private final List<Application> windowsApps = new ArrayList<>();
    public Windows(String WindowsOsName, String config, double price, MotherBoard motherBoard) {
        super(motherBoard);
        this.WindowsOsId = "OSWIN-" + abs(this.hashCode());
        this.WindowsOsName = WindowsOsName;
        this.config = config;
        this.price = price;
        this.windowsApps.add(new BankApp());
    }

    @Override
    public List<Application> getApplication() {
        return windowsApps;
    }

    public interface WindowsApps{

    }
    @Override
    public String toString() {
        return  this.getClass().getSuperclass().getSimpleName()+"\n"+"\n"+
                "OsId='" + WindowsOsId + '\n' +
                "Name='" + WindowsOsName + '\n' +
                "config='" + config + '\n' ;
    }

    @Override
    public String getName() {
        return WindowsOsName;
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
