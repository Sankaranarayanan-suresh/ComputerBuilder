package com.computer.software.os.os;

import com.computer.hardware.part.motherboard.MotherBoardDriver;
import com.computer.software.os.ApplicationInterface;
import com.computer.computer.ComputerParts;

import java.util.*;

public abstract class Os implements ComputerParts, OsApplicationInteractionInterface {
    private boolean shutDown = true;
    private final MotherBoardDriver motherBoardDriver;
    private List<ApplicationInterface> listOfApplications;

    public Os(MotherBoardDriver motherBoardDriver) {
        this.motherBoardDriver = motherBoardDriver;
    }

    public abstract List<ApplicationInterface> getApplication();

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

    public void driverFunction() {
        boolean isValidInput = true;
        while (shutDown) {
            if (isValidInput) {
                motherBoardDriver.putInput("1.Launch Pad\n2.Settings\n3.Shut down");
            }
            isValidInput = makeDecision(fetchInput());
        }
    }

    public boolean checkNetworkStatus() {
        return motherBoardDriver.checkNetStatus();
    }

    private boolean makeDecision(String input) {
        switch (input) {
            case "1": {
                launchPad();
                String option = fetchInput();
                if (Integer.parseInt(option) <= listOfApplications.size()) {
                    ApplicationInterface application = listOfApplications.get(Integer.parseInt(option) - 1);
                    loadApplication(application);
                    initiateApplication(application);
                    closeApplication();
                } else {
                    return true;
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
                return false;
            case "k connected":
                return true;
            default:
                motherBoardDriver.putInput("Cannot perform that action.");
                return true;
        }
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
    private void loadApplication(ApplicationInterface application) {
        load(application);
    }

    private void initiateApplication(ApplicationInterface application) {
        motherBoardDriver.startApplication(application, this);
    }

    private void closeApplication() {
        motherBoardDriver.deleteAppFromRam();
    }

    private void load(ApplicationInterface application) {
        motherBoardDriver.loadToRam(application);
    }

    public void boot() {
        motherBoardDriver.putInput("OS BOOTING");
        try {
            Thread.sleep(1000);
            // this function is used to load all the application when the computer is turned on.
            loadAllApps(getApplication());
            listOfApplications = motherBoardDriver.fetchApplications();
            motherBoardDriver.putInput("BOOT PROCESS COMPLETE...\n\n");
            motherBoardDriver.putInput("****************************** WELCOME TO " + this.getClass().getSimpleName() + " OS ******************************");
        } catch (Exception ignored) {

        }
    }

    private void loadAllApps(List<ApplicationInterface> defaultApps) {
        for (ApplicationInterface apps : defaultApps) {
            motherBoardDriver.loadApplication(apps);
        }
    }

    private void launchPad() {
        int i;
        for (i = 0; i < listOfApplications.size(); i++) {
            motherBoardDriver.putInput(i + 1 + "." + listOfApplications.get(i).getName());
        }
        motherBoardDriver.putInput(i + 1 + "." + "Exit");
    }
}
