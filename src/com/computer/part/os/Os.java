package com.computer.part.os;

import com.computer.applications.Application;
import com.computer.applications.Calculator;
import com.computer.applications.GSearch;
import com.computer.computer.ComputerParts;
import com.sun.xml.internal.bind.v2.TODO;

import java.util.HashMap;
import java.util.List;

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

    public  void driverFunction() {
        while (shutDown) {
            osInterface.putInput("1.Show List of Applications\n2.Settings\n3.Shut down");
                makeDecision(fetchInput());
        }
    }

    public boolean checkNetworkStatus() {
        return osInterface.checkNetStatus();
    }

    private void makeDecision(String input) {
        try{
            switch (input) {
                case "1": {
                    showListOfApps();
                    osInterface.putInput("Select Any Option");
                    loadApplication();
                    break;
                }
                case "2": {
                    settings();
                    break;
                }
                case "3":
                    osInterface.putInput("Shutting Down......");
                    // shutdownm name maathanu.
                    shutDown = false;
                    break;
                default:
                    osInterface.putInput("Cannot perform that action.");
                    break;
            }
        }catch (Exception e){
            osInterface.putInput("ADD part keyboard.");
        }
    }
    private void settings(){
        osInterface.putInput("1.Network\n2.About PC");
        String option = fetchInput();
        if (option.equals("1")) {
            boolean netStatus = checkNetworkStatus();
            if (netStatus) {
                String status = netStatus ? "Off" : "On";
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
        } else if (option.equals("2")) {
            HashMap part = osInterface.getParts();
            for (Object mapElement : part.entrySet()) {
                try {
                    Thread.sleep(600);
                    osInterface.putInput(mapElement.toString());
                } catch (Exception e) {

                }
            }

        }
    }
    private void loadApplication(){
        String option = fetchInput();
        if (option.equals("1")) {
            Application application = x.get(0);
            load(application);
        } else if (option.equals("2")) {
            Application application = x.get(1);
            load(application);
        } else {
            osInterface.putInput("Cannot perform that action.");
        }
    }

    private void load(Application application) {
        osInterface.loadToRam(application);
    }

    public void boot() {
        System.out.println("OS BOOTING........");
        try {
            Thread.sleep(1000);
            System.out.println("BOOT PROCESS COMPLETE...\n");
        } catch (Exception e) {

        }
        x = osInterface.fetchList();
        loadAllApps();
    }

    private void loadAllApps() {
        osInterface.loadApplication(new Calculator(this));
        osInterface.loadApplication(new GSearch(this));
    }

    private void showListOfApps() {
        for (int i = 0; i < x.size(); i++) {
            System.out.println(i + 1 + "." + x.get(i).getName());
        }
    }

    @Override
    public String getCategory() {
        return "OS";
    }
}
