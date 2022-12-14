package com.computer.hardware.part.storage.RAM;

import com.computer.hardware.part.storage.Storage;
import com.computer.software.application.Application;

public abstract class RAM extends Storage {
    public abstract void write(Application app);

    public abstract Application read(Application app);
    public abstract  void remove();
}
