package com.computer.hardware.part.processor;

import com.computer.software.os.ApplicationInterface;
import com.computer.computer.ComputerParts;
import com.computer.software.os.os.OsApplicationInteractionInterface;

public abstract class Processor implements ComputerParts, ProcessorInterface {
    @Override
    public void runApp(ApplicationInterface application, OsApplicationInteractionInterface sys) {
        try {
            application.run(sys);
        }catch (Exception e){
            System.out.println("Application crashed!!!!!!!");
        }

    }
}
