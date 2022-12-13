package com.computer.software.os;

import com.computer.software.application.Application;
import com.computer.software.application.Calculator;
import com.computer.software.application.GSearch;
import com.computer.computer.ComputerParts;


import java.util.*;

public abstract class Os implements ComputerParts, ApplicationInterface {
    private boolean shutDown = true;
    private final OsInterface osInterface;
    private List<Application> x;

    public Os(OsInterface osInterface) {
        this.osInterface = osInterface;
    }

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

    public void driverFunction() {
        while (shutDown) {
            osInterface.putInput("1.Show List of Applications\n2.Settings\n3.Shut down");
            makeDecision(fetchInput());
        }
    }

    public boolean checkNetworkStatus() {
        return osInterface.checkNetStatus();
    }

    private void makeDecision(String input) {
        try {
            switch (input) {
                case "1": {
                    showListOfApps();
                    //load all applications into RAM.
                    loadApplication();
                    break;
                }
                case "2": {
                    settings();
                    break;
                }
                case "3":
                    osInterface.putInput("Shutting Down......");
                    // shutdown name change.
                    shutDown = false;
                    break;
                default:
                    osInterface.putInput("Cannot perform that action.");
                    break;
            }
        } catch (InputMismatchException e) {
            osInterface.putInput("ADD part keyboard.");
        }
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
                            //exit.....
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
                            //exit.....
                        } else {
                            osInterface.putInput("Cannot perform that action.");
                        }
                    }
                    break;
                case "2":
                    Collection<ComputerParts> part = osInterface.getParts();
                    for (Object mapElement : part) {
                        try {
                            Thread.sleep(300);
                            osInterface.putInput(mapElement.toString());
                        } catch (Exception ignored) {

                        }
                    }

                    break;
                case "3":
                    break label;
            }
        }
    }

//this function is used to load application into RAM based on user input.
    private void loadApplication() {
        String option = fetchInput();
        switch (option) {
            case "1": {
                Application application = x.get(0);
                load(application);
                initiateApplication(application);
                break;
            }
            case "2": {
                Application application = x.get(1);
                load(application);
                initiateApplication(application);
                break;
            }
            case "3":
                break;
            default:
                osInterface.putInput("Cannot perform that action.");
                break;
        }
    }
    private void initiateApplication(Application application){
        osInterface.startApplication(application);
    }
    private void load(Application application) {
        osInterface.loadToRam(application);
    }

    public void boot() {
        System.out.println("OS BOOTING........");
        try {
            Thread.sleep(1000);
            System.out.println("BOOT PROCESS COMPLETE...\n");
        } catch (Exception ignored) {

        }
        x = osInterface.fetchList();
        // this function is used to load all the application when the computer is turned on.
        loadAllApps();
    }

    private void loadAllApps() {
        osInterface.loadApplication(new Calculator(this));
        osInterface.loadApplication(new GSearch(this));
    }

    private void showListOfApps() {
        int i;
        for (i = 0; i < x.size(); i++) {
            System.out.println(i + 1 + "." + x.get(i).getName());
        }
        System.out.println(i + 1 + "." + "Exit");
    }

    @Override
    public String getCategory() {
        return "OS";
    }
}
