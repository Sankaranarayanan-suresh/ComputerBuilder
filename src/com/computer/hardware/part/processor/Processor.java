package com.computer.hardware.part.processor;

import com.computer.software.application.Application;
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
