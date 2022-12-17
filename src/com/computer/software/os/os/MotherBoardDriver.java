package com.computer.software.os.os;

import com.computer.software.os.mac.application.*;
import java.util.List;

public interface MotherBoardDriver {
    String getOverallConfiguration();

    void updateNetwork();

    void startApplication(Application application, ApplicationInterface sys);
    void deleteAppFromRam();

    List<Application> fetchApplications();

    String getInput();

    void loadToRam(Application application);

    void loadApplication(Application app);

    boolean checkNetStatus();

    void putInput(Object input);
}
