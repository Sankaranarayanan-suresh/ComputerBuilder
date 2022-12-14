package com.computer.software.application;

import com.computer.software.os.ApplicationInterface;

public interface Application {
    String getName();

    String getVersion();

    void run(ApplicationInterface sys);
}
