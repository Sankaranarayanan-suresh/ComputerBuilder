package com.computer.hardware.part.motherboard;

import com.computer.software.os.ApplicationInterface;
import com.computer.software.os.os.OsApplicationInteractionInterface;

import java.util.List;

public interface MotherBoardDriver {
    String getOverallConfiguration();

    void updateNetwork();

    void startApplication(ApplicationInterface application, OsApplicationInteractionInterface sys);

    void deleteAppFromRam();

    List<ApplicationInterface> fetchApplications();

    String getInput();

    void loadToRam(ApplicationInterface application);

    void loadApplication(ApplicationInterface app);

    boolean checkNetStatus();

    void putInput(Object input);
}
