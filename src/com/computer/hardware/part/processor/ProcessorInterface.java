package com.computer.hardware.part.processor;

import com.computer.software.os.mac.application.*;
import com.computer.software.os.OS.ApplicationInterface;

public interface ProcessorInterface {
    void runApp(Application app, ApplicationInterface sys);
}
