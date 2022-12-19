package com.computer.hardware.part.storage.RAM;

import com.computer.hardware.part.storage.Storage;
import com.computer.software.os.ApplicationInterface;

public abstract class RAM extends Storage {
    public abstract void write(ApplicationInterface app);

    public abstract ApplicationInterface read(ApplicationInterface app);
    public abstract  void remove();
}
