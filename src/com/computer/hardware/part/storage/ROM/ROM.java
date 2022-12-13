package com.computer.hardware.part.storage.ROM;

import com.computer.software.application.Application;
import com.computer.hardware.part.storage.Storage;

import java.util.List;

public abstract class ROM extends Storage {

    public abstract void addApplication(Application app);

    public abstract List returnLists();
}
