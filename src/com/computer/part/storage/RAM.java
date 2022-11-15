package com.computer.part.storage;

import com.computer.applications.Application;
import com.computer.part.processor.ProcessorInterface;

public class RAM extends Storage {
    private static int RAMCounter = 0;
    private final String RAMId;
    private final String RAMName;
    private final String config;
    private final double price;
    ProcessorInterface processorInterface;

    public RAM(String RAMName, String config, double price, ProcessorInterface processor) {
        this.RAMId = "RAM/" + ++RAMCounter;
        this.RAMName = RAMName;
        this.config = config;
        this.price = price;
        this.processorInterface = processor;
    }

    @Override
    public String toString() {
        return "RAM{" +
                "RAMId='" + RAMId + '\'' +
                ", RAMName='" + RAMName + '\'' +
                ", config='" + config + '\'' +
                '}';
    }

    public void runApplication(Application application) {
        processorInterface.runApp(application);
    }

    @Override
    public String getType() {
        return "RAM";
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

    @Override
    public String getId() {
        return RAMId;
    }

    @Override
    public String getCategory() {
        return "RAM";
    }


}
