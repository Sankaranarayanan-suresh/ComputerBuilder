package com.computer.software.os.mac.application;

import com.computer.software.os.OS.ApplicationInterface;
import com.computer.software.os.mac.Mac.MacApps;

public interface Application extends MacApps {
    String getName();

    String getVersion();

    void run(ApplicationInterface sys);
}
