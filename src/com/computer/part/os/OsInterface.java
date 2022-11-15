package com.computer.part.os;

import com.computer.applications.Application;

import java.util.HashMap;
import java.util.List;

public interface OsInterface {
    HashMap getParts();

    void updateNetwork();

    List<Application> fetchList();

    String getInput();

    void loadToRam(Application application);

    void loadApplication(Application app);

    boolean checkNetStatus();

    void putInput(Object input);
}
