package com.computer.part.processor;

public class Intel extends Processor {
    private static int intelPCounter = 0;
    private final String processorId;
    private final String processorName;
    private final String config;
    private final double price;

    public Intel(String processorName, String config, double price) {
        this.processorId = "Mac/" + ++intelPCounter;
        this.processorName = processorName;
        this.config = config;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Intel{" +
                "processorId='" + processorId + '\'' +
                ", processorName='" + processorName + '\'' +
                ", config='" + config + '\'' +
                '}';
    }

    @Override
    public String getType() {
        return null;
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