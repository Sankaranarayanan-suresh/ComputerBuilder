package com.computer.hardware.part.storage.RAM;

import com.computer.software.application.Application;
import com.computer.hardware.part.storage.Storage;

public abstract class RAM extends Storage {
    public abstract void storeApplication(Application application);

    public abstract Application fetchApp(Application app);
}
