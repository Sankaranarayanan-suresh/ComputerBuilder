package com.computer.part.os;

import com.computer.applications.Application;
import com.computer.computer.ComputerParts;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public interface OsInterface {
    Collection<ComputerParts> getParts();

    void updateNetwork();
    void startApplication(Application application);

    List<Application> fetchList();

    String getInput();

    void loadToRam(Application application);

    void loadApplication(Application app);

    boolean checkNetStatus();

    void putInput(Object input);
}
