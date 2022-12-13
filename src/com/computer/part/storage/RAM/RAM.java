package com.computer.part.storage.RAM;

import com.computer.applications.Application;
import com.computer.part.storage.Storage;

public abstract class RAM extends Storage {
    public abstract void storeApplication(Application application);

    public abstract Application fetchApp(Application app);
}
