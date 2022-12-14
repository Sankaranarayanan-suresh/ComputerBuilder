package com.computer.hardware.part.processor;

import com.computer.software.application.*;
import com.computer.software.os.ApplicationInterface;
import com.computer.software.os.Os;

public interface ProcessorInterface {
    void runApp(Application app, ApplicationInterface sys);
}
