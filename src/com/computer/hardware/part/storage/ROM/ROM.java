package com.computer.hardware.part.storage.ROM;

import com.computer.hardware.part.storage.Storage;
import com.computer.software.os.mac.application.Application;

import java.util.List;

public abstract class ROM extends Storage {

    public abstract void addApplication(Application app);

    public abstract List<Application> returnApplications();
}
