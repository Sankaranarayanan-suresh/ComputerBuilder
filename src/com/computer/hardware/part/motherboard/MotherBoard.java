package com.computer.hardware.part.motherboard;

import com.computer.software.application.Application;
import com.computer.computer.ComputerParts;
import com.computer.hardware.part.keyboard.Keyboard;
import com.computer.hardware.part.monitor.Monitor;
import com.computer.hardware.part.networkcard.NetworkCard;
import com.computer.software.os.Os;
import com.computer.software.os.OsInterface;
import com.computer.hardware.part.processor.Processor;
import com.computer.hardware.part.storage.RAM.RAM;
import com.computer.hardware.part.storage.ROM.ROM;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class MotherBoard implements ComputerParts, OsInterface {
    private Monitor monitor;
    private Os os;
    private ROM rom;
    private RAM ram;
    private Keyboard keyboard;
    private NetworkCard networkCard;
    private Processor processor;
    public HashMap<String, ComputerParts> computerParts = new HashMap<>();

    public void addPart(ComputerParts computerPart) {
        computerParts.put(computerPart.getCategory(), computerPart);
    }

    public void biosBoot() {
        for (Map.Entry<String, ComputerParts> mapElement : computerParts.entrySet()) {
            try {
                Thread.sleep(600);
                System.out.println(mapElement.getValue().getCategory() + " is checked");
                if (mapElement.getValue() instanceof Os) {
                    os = (Os) mapElement.getValue();
                } else if (mapElement.getValue() instanceof Monitor) {
                    monitor = (Monitor) mapElement.getValue();
                } else if (mapElement.getValue() instanceof Keyboard) {
                    keyboard = (Keyboard) mapElement.getValue();
                } else if (mapElement.getValue() instanceof ROM) {
                    rom = (ROM) mapElement.getValue();
                } else if (mapElement.getValue() instanceof RAM) {
                    ram = (RAM) mapElement.getValue();
                } else if (mapElement.getValue() instanceof NetworkCard) {
                    networkCard = (NetworkCard) mapElement.getValue();
                } else if (mapElement.getValue() instanceof Processor) {
                    processor = (Processor) mapElement.getValue();
                }
            } catch (Exception ignored) {

            }
        }
        try {
            Thread.sleep(600);
        } catch (Exception e) {

        }
        os.boot();
    }

    public Collection<ComputerParts> getParts() {
        return computerParts.values();
    }

    public void print(String text) {
        this.monitor.display(text);
    }

    public void updateNetwork() {
        networkCard.updateStatus();
    }

    @Override
    public String getInput() {
        if (keyboard != null) {
            return keyboard.getInput();
        }
        print("No Keyboard found.");
        return null;
    }
    public void startApplication(Application application){
        Application app = ram.fetchApp(application);
        processor.runApp(app);
    }

    public void loadApplication(Application app) {
        rom.addApplication(app);
    }

    public boolean checkNetStatus() {
        if (networkCard != null) {
            return networkCard.status();
        }
        System.out.println("NO Network-Card found. ");
        return false;
    }
    @Override
    public void loadToRam(Application application) {
        ram.storeApplication(application);
    }

    @Override
    public List fetchList() {
        return rom.returnLists();
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
