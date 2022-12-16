package com.computer.hardware.part.motherboard;

import com.computer.hardware.part.keyboard.Mechanical;
import com.computer.hardware.part.keyboard.Qwerty;
import com.computer.hardware.part.processor.ProcessorInterface1;
import com.computer.software.os.mac.application.Application;
import com.computer.computer.ComputerParts;
import com.computer.hardware.part.keyboard.Keyboard;
import com.computer.hardware.part.monitor.Monitor;
import com.computer.hardware.part.networkcard.NetworkCard;
import com.computer.software.os.OS.ApplicationInterface;
import com.computer.software.os.OS.Os;
import com.computer.software.os.OS.OsInterface;
import com.computer.hardware.part.processor.Processor;
import com.computer.hardware.part.storage.RAM.RAM;
import com.computer.hardware.part.storage.ROM.ROM;
import com.util.Utils;

import java.util.List;
import java.util.Scanner;

public abstract class MotherBoard implements ComputerParts, OsInterface, ProcessorInterface1 {
    //ram,rom,processor,monitor,keyboard,os,networkCard
    private RAM ram;
    private ROM rom;
    private Processor processor;
    private Monitor monitor;
    private Keyboard keyboard;
    private Os os;
    private NetworkCard networkCard;

    public void addPart(ComputerParts computerPart) {
        if (computerPart instanceof Os) {
            os = (Os) computerPart;
        } else if (computerPart instanceof Monitor) {
            monitor = (Monitor) computerPart;
        } else if (computerPart instanceof Keyboard) {
            keyboard = (Keyboard) computerPart;
        } else if (computerPart instanceof ROM) {
            rom = (ROM) computerPart;
        } else if (computerPart instanceof RAM) {
            ram = (RAM) computerPart;
        } else if (computerPart instanceof NetworkCard) {
            networkCard = (NetworkCard) computerPart;
        } else if (computerPart instanceof Processor) {
            processor = (Processor) computerPart;
        }
    }

    public void biosBoot() {
        initializer(this);
        initializer(processor);
        initializer(ram);
        initializer(rom);
        initializer(os);
        initializer(networkCard);
        initializer(keyboard);
        initializer(monitor);
        print("");
        os.boot();
    }

    private void initializer(ComputerParts part) {
        try {
            print("Checking " + part.getClass().getSuperclass().getSimpleName());
            Thread.sleep(600);
        } catch (Exception ignored) {

        }

    }

    public String getOverallConfiguration() {
        return rom.toString() + "\n" +
                ram.toString() + "\n" +
                os.toString() + "\n" +
                processor.toString() + "\n" +
                monitor.toString() + "\n" +
                keyboard.toString() + "\n" +
                networkCard.toString() + "\n" +
                this;
    }

    private void print(String text) {
        try {
            this.monitor.display(text);
        } catch (RuntimeException e) {
            System.out.print("NO MONITOR!!!");
            System.exit(1);
        }
    }

    public void updateNetwork() {
        networkCard.toggleStatus();
    }

    @Override
    public String getInput() {
        if (keyboard != null) {
            return keyboard.getInput();
        }else {
            String keboardStatus = Utils.deviceManager();
            if (keboardStatus.equals("k connected")) {
                keyboard = new Qwerty("mac", "Mechanical keyboard", 1000);
                return keboardStatus;
            }
            return keboardStatus;
        }
    }
    public void startApplication(Application application, ApplicationInterface sys) {
        Application app = ram.read(application);
        processor.runApp(app, sys);
    }

    public void deleteAppFromRam() {
        ram.remove();
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
        ram.write(application);
    }

    @Override
    public List<Application> fetchApplications() {
        return rom.returnApplications();
    }

    @Override
    public void putInput(Object input) {
        print(input.toString());
    }
}
