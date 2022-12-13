package com.computer.part.storage.ROM;

import com.computer.applications.Application;
import com.computer.part.storage.Storage;

import java.util.List;

public abstract class ROM extends Storage {

    public abstract void addApplication(Application app);

    public abstract List returnLists();
}
