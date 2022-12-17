package com.computer.hardware.part.processor;

import com.computer.software.os.mac.application.*;
import com.computer.computer.ComputerParts;
import com.computer.software.os.os.ApplicationInterface;

public abstract class Processor implements ComputerParts, ProcessorInterface {
    @Override
    public void runApp(Application application, ApplicationInterface sys) {
        try {
            application.run(sys);
        }catch (Exception e){
            System.out.println("Application crashed!!!!!!!");
        }

    }
}
