package com.computer.part.processor;

import com.computer.applications.Application;
import com.computer.computer.ComputerParts;

public abstract class Processor implements ComputerParts, ProcessorInterface {
    @Override
    public void runApp(Application application) {
        Application app = application;
        app.run();
    }

    @Override
    public String getCategory() {
        return "Processor";
    }
}
