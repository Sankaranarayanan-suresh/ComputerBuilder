package com.computer.software.os.OS;

import com.computer.software.os.mac.application.Application;
import com.computer.computer.ComputerParts;

import java.util.*;

public abstract class Os implements ComputerParts, ApplicationInterface {
    private boolean shutDown = true;
    private final OsInterface osInterface;
    private List<Application> x;

    public Os(OsInterface osInterface) {
        this.osInterface = osInterface;
    }

    public abstract List<Application> getApplication();

    @Override
    public String gets() {
        return osInterface.getInput();
    }

    @Override
    public void puts(Object text) {
        osInterface.putInput(text);
    }

    private String fetchInput() {
            return osInterface.getInput();
    }

    public void driverFunction()  {
        boolean isValidInput = true;
        while (shutDown) {
            if (isValidInput){
                osInterface.putInput("1.Launch Pad\n2.Settings\n3.Shut down");
            }
            isValidInput = makeDecision(fetchInput());
        }
    }

    public boolean checkNetworkStatus() {
        return osInterface.checkNetStatus();
    }

    private boolean makeDecision(String input)  {
        try {
            switch (input) {
                case "1": {
                    launchPad();
                    //load all applications into RAM.
                    String option = fetchInput();
                    switch (option) {
                        case "1": {
                            //loading calculator application
                            Application application = x.get(0);
                            loadApplication(application);
                            initiateApplication(application);
                            closeApplication();
                            break;
                        }
                        case "2": {
                            //loading gSearch application
                            Application application = x.get(1);
                            loadApplication(application);
                            initiateApplication(application);
                            closeApplication();
                            break;
                        }
                        case "3":
                            break;
                        default:
                            osInterface.putInput("Cannot perform that action.");
                            break;
                    }
                    return true;
                }
                case "2": {
                    settings();
                    return true;
                }
                case "3":
                    osInterface.putInput("Shutting Down......");
                    // shutdown name change.
                    shutDown = false;
                    return true;
                case "":
                    osInterface.putInput("No Keyboard Connected!!!");
                    return false;
                case "k connected":
                    return true;
                default:
                    osInterface.putInput("Cannot perform that action.");
                    return true;
            }
        } catch (InputMismatchException e) {
            osInterface.putInput("ADD part keyboard.");
        }
        return false;
    }


    private void settings() {
        label:
        while (true) {
            osInterface.putInput("1.Network\n2.About PC\n3.Exit");
            String option = fetchInput();
            switch (option) {
                case "1":
                    boolean netStatus = checkNetworkStatus();
                    if (netStatus) {
                        String status = "Off";
                        osInterface.putInput("1.Turn-" + status + " Network\n2.Exit");
                        String netOption = fetchInput();
                        if (netOption.equals("1")) {
                            osInterface.updateNetwork();
                        } else if (netOption.equals("2")) {
                            continue;
                        } else {
                            osInterface.putInput("Cannot perform that action.");
                        }
                    } else {
                        String status = "On";
                        osInterface.putInput("1.Turn-" + status + " Network\n2.Exit");
                        String netOption = fetchInput();
                        if (netOption.equals("1")) {
                            osInterface.updateNetwork();
                        } else if (netOption.equals("2")) {
                            continue;
                        } else {
                            osInterface.putInput("Cannot perform that action.");
                        }
                    }
                    break;
                case "2":
                    try {
                        Thread.sleep(300);
                        osInterface.putInput(osInterface.getOverallConfiguration());
                    } catch (Exception ignored) {

                    }
                    break;
                case "3":
                    break label;
            }
        }
    }

    //this function is used to load application into RAM based on user input.
    private void loadApplication(Application application) {
        load(application);
    }

    private void initiateApplication(Application application) {
        osInterface.startApplication(application, this);
    }

    private void closeApplication() {
        osInterface.deleteAppFromRam();
    }

    private void load(Application application) {
        osInterface.loadToRam(application);
    }

    public void boot() {
        osInterface.putInput("OS BOOTING");
        try {
            Thread.sleep(1000);
            // this function is used to load all the application when the computer is turned on.
            List<Application> defaultApps = getApplication();
            loadAllApps(defaultApps);
            x = osInterface.fetchApplications();
            osInterface.putInput("BOOT PROCESS COMPLETE...\n\n");
            osInterface.putInput("****************************** WELCOME TO " + this.getClass().getSimpleName() + " OS ******************************");
        } catch (Exception ignored) {

        }
    }

    private void loadAllApps(List<Application> defaultApps) {
        for (Application apps : defaultApps) {
            osInterface.loadApplication(apps);
        }
    }

    private void launchPad() {
        int i;
        for (i = 0; i < x.size(); i++) {
            osInterface.putInput(i + 1 + "." + x.get(i).getName());
        }
        osInterface.putInput(i + 1 + "." + "Exit");
    }
}
