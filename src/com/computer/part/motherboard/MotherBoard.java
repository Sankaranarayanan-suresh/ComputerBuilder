package com.computer.part.motherboard;

import com.computer.applications.Application;
import com.computer.computer.ComputerParts;
import com.computer.part.keyboard.Keyboard;
import com.computer.part.monitor.Monitor;
import com.computer.part.networkcard.NetworkCard;
import com.computer.part.os.Os;
import com.computer.part.os.OsInterface;
import com.computer.part.storage.HDD;
import com.computer.part.storage.RAM;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class MotherBoard implements ComputerParts, OsInterface {
    private Monitor monitor;
    private Os os;
    private HDD hdd;
    private RAM ram;
    private Keyboard keyboard;
    private NetworkCard networkCard;
    public HashMap<String, ComputerParts> computerParts = new HashMap<String, ComputerParts>();

    public void addPart(ComputerParts computerPart) {
        computerParts.put(computerPart.getCategory(), computerPart);
    }

    public void biosBoot() {
        for (Map.Entry<String, ComputerParts> mapElement : computerParts.entrySet()) {
            try {
                Thread.sleep(600);
                print(mapElement.getValue().getCategory() + " is checked");
                os = (Os) computerParts.get("OS");
            } catch (Exception e) {

            }
        }
        try {
            Thread.sleep(600);
        } catch (Exception e) {

        }
        os.boot();
    }

    public HashMap getParts() {
        return computerParts;
    }

    public void print(String text) {
        monitor = (Monitor) computerParts.get("Monitor");
        this.monitor.display(text);
    }

    public void updateNetwork() {
        networkCard.updateStatus();
    }

    @Override
    public String getInput() {
        keyboard = (Keyboard) computerParts.get("Keyboard");
        return keyboard.getInput();
    }

    public void loadApplication(Application app) {
        hdd.addApplication(app);
    }

    public boolean checkNetStatus() {
        networkCard = (NetworkCard) computerParts.get("Network card");
        if(networkCard != null) {
            return networkCard.status();
        }
        print("NO Network-Card found. ");
        return false;
    }

    @Override
    public void loadToRam(Application application) {
        ram = (RAM) computerParts.get("RAM");
        ram.runApplication(application);
    }

    @Override
    public List fetchList() {
        hdd = (HDD) computerParts.get("Storage");
        return hdd.returnLists();
    }

    @Override
    public void putInput(Object input) {
        print(input.toString());
    }

    @Override
    public String getCategory() {
        return "MotherBoard";
    }


}
