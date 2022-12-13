package com.computer.part.processor;

import static java.lang.Math.abs;

public class Intel extends Processor {
    private final String processorId;
    private final String processorName;
    private final String config;
    private final double price;

    public Intel(String processorName, String config, double price) {
        this.processorId = "PROCIN-" + abs(this.hashCode());
        this.processorName = processorName;
        this.config = config;
        this.price = price;
    }
    @Override
    public String toString() {
        return  "processorId='" + processorId + '\n' +
                "processorName='" + processorName + '\n' +
                "config='" + config + '\n' ;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getConfig() {
        return null;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getId() {
        return null;
    }
}
