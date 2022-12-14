package com.computer.hardware.part.storage.RAM;

import com.computer.software.os.ApplicationInterface;

import static java.lang.Math.abs;

public class DDR3 extends RAM {
    private final String RAMId;
    private final String RAMName;
    private final String config;
    private final double price;
    private ApplicationInterface application;


    public DDR3(String RAMName, String config, double price) {
        this.RAMId = "RAMDDR3-" + abs(this.hashCode());
        this.RAMName = RAMName;
        this.config = config;
        this.price = price;
    }

    @Override
    public String toString() {
        return  this.getClass().getSuperclass().getSimpleName()+"\n"+"\n"+
                "RAMId='" + RAMId + '\n' +
                "RAMName='" + RAMName + '\n' +
                "config='" + config + '\n';
    }

    public void write(ApplicationInterface application) {
       this.application = application;
    }

    @Override
    public ApplicationInterface read(ApplicationInterface app) {
        return this.application;
    }

    @Override
    public void remove() {
        application = null;
    }

    @Override
    public String getName() {
        return RAMName;
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
