package com.computer.software.os;

import com.computer.software.os.os.OsApplicationInteractionInterface;

public interface ApplicationInterface {
    String getName();

    String getVersion();
    void run(OsApplicationInteractionInterface sys);
}
