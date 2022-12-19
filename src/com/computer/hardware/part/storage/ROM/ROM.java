package com.computer.hardware.part.storage.ROM;

import com.computer.hardware.part.storage.Storage;
import com.computer.software.os.ApplicationInterface;

import java.util.List;

public abstract class ROM extends Storage {

    public abstract void addApplication(ApplicationInterface app);

    public abstract List<ApplicationInterface> returnApplications();
}
