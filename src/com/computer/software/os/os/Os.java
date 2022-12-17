package com.computer.software.os.os;

import com.computer.software.os.mac.application.Application;
import com.computer.computer.ComputerParts;

import java.util.*;

public abstract class Os implements ComputerParts, ApplicationInterface {

    private boolean shutDown = true;
    private final MotherBoardDriver motherBoardDriver;
    private List<Application> x;

    public Os(MotherBoardDriver osInterface) {
        this.motherBoardDriver = osInterface;
    }

    public abstract List<Application> getApplication();

    @Override
    public String gets() {
        return motherBoardDriver.getInput();
    }

    @Override
    public void puts(Object text) {
        motherBoardDriver.putInput(text);
    }

    private String fetchInput() {
            return motherBoardDriver.getInput();
    }

    public void driverFunction()  {
        boolean isValidInput = true;
        while (shutDown) {
            if (isValidInput){
                motherBoardDriver.putInput("1.Launch Pad\n2.Settings\n3.Shut down");
            }
            isValidInput = makeDecision(fetchInput());
        }
    }

    public boolean checkNetworkStatus() {
        return motherBoardDriver.checkNetStatus();
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
                            motherBoardDriver.putInput("Cannot perform that action.");
                            break;
                    }
                    return true;
                }
                case "2": {
                    settings();
                    return true;
                }
                case "3":
                    motherBoardDriver.putInput("Shutting Down......");
                    // shutdown name change.
                    shutDown = false;
                    return true;
                case "":
                    motherBoardDriver.putInput("No Keyboard Connected!!!");
                    return false;
                case "k connected":
                    return true;
                default:
                    motherBoardDriver.putInput("Cannot perform that action.");
                    return true;
            }
        } catch (InputMismatchException e) {
            motherBoardDriver.putInput("ADD part keyboard.");
        }
        return false;
    }


    private void settings() {
        label:
        while (true) {
            motherBoardDriver.putInput("1.Network\n2.About PC\n3.Exit");
            String option = fetchInput();
            switch (option) {
                case "1":
                    boolean netStatus = checkNetworkStatus();
                    if (netStatus) {
                        String status = "Off";
                        motherBoardDriver.putInput("1.Turn-" + status + " Network\n2.Exit");
                        String netOption = fetchInput();
                        if (netOption.equals("1")) {
                            motherBoardDriver.updateNetwork();
                        } else if (netOption.equals("2")) {
                            continue;
                        } else {
                            motherBoardDriver.putInput("Cannot perform that action.");
                        }
                    } else {
                        String status = "On";
                        motherBoardDriver.putInput("1.Turn-" + status + " Network\n2.Exit");
                        String netOption = fetchInput();
                        if (netOption.equals("1")) {
                            motherBoardDriver.updateNetwork();
                        } else if (netOption.equals("2")) {
                            continue;
                        } else {
                            motherBoardDriver.putInput("Cannot perform that action.");
                        }
                    }
                    break;
                case "2":
                    try {
                        Thread.sleep(300);
                        motherBoardDriver.putInput(motherBoardDriver.getOverallConfiguration());
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
        motherBoardDriver.startApplication(application, this);
    }

    private void closeApplication() {
        motherBoardDriver.deleteAppFromRam();
    }

    private void load(Application application) {
        motherBoardDriver.loadToRam(application);
    }

    public void boot() {
        motherBoardDriver.putInput("OS BOOTING");
        try {
            Thread.sleep(1000);
            // this function is used to load all the application when the computer is turned on.
            List<Application> defaultApps = getApplication();
            loadAllApps(defaultApps);
            x = motherBoardDriver.fetchApplications();
            motherBoardDriver.putInput("BOOT PROCESS COMPLETE...\n\n");
            motherBoardDriver.putInput("****************************** WELCOME TO " + this.getClass().getSimpleName() + " OS ******************************");
        } catch (Exception ignored) {

        }
    }

    private void loadAllApps(List<Application> defaultApps) {
        for (Application apps : defaultApps) {
            motherBoardDriver.loadApplication(apps);
        }
    }

    private void launchPad() {
        int i;
        for (i = 0; i < x.size(); i++) {
            motherBoardDriver.putInput(i + 1 + "." + x.get(i).getName());
        }
        motherBoardDriver.putInput(i + 1 + "." + "Exit");
    }
}
