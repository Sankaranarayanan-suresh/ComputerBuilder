package com.computer.hardware.part.processor;

import com.computer.software.os.ApplicationInterface;
import com.computer.software.os.os.OsApplicationInteractionInterface;

public interface ProcessorInterface {
    void runApp(ApplicationInterface app, OsApplicationInteractionInterface sys);
}
