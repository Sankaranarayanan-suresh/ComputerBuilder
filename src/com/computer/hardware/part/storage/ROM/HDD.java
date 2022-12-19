package com.computer.hardware.part.storage.ROM;

import com.computer.software.os.ApplicationInterface;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class HDD extends ROM {
    private final String HDDId;
    private final String HDDName;
    private final String config;
    private final double price;
    private final ArrayList<ApplicationInterface> applications = new ArrayList<>();

    public List<ApplicationInterface> returnApplications() {
        return applications;
    }

    public HDD(String HDDName, String config, double price) {
        this.HDDId = "ROMHDD-" + abs(this.hashCode());
        this.HDDName = HDDName;
        this.config = config;
        this.price = price;
    }

    @Override
    public String toString() {
        return  this.getClass().getSuperclass().getSimpleName()+"\n"+"\n"+
                "HDDId='" + HDDId + '\n' +
                "HDDName='" + HDDName + '\n' +
                "config='" + config + '\n' ;
    }

    public void addApplication(ApplicationInterface app) {
        applications.add(app);
    }

    @Override
    public String getName() {
        return HDDName;
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
