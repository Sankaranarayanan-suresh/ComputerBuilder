package com.computer.hardware.part.motherboard;

import com.computer.hardware.part.processor.ProcessorInterface1;
import com.computer.software.application.Application;
import com.computer.computer.ComputerParts;
import com.computer.hardware.part.keyboard.Keyboard;
import com.computer.hardware.part.monitor.Monitor;
import com.computer.hardware.part.networkcard.NetworkCard;
import com.computer.software.os.ApplicationInterface;
import com.computer.software.os.Os;
import com.computer.software.os.OsInterface;
import com.computer.hardware.part.processor.Processor;
import com.computer.hardware.part.storage.RAM.RAM;
import com.computer.hardware.part.storage.ROM.ROM;

import java.util.List;

public abstract class MotherBoard implements ComputerParts, OsInterface , ProcessorInterface1 {
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
        //computerParts.put(computerPart.getCategory(), computerPart);
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
        if (part !=null){
            try {
                print("Initializing " + part.getClass().getSuperclass().getSimpleName());
                Thread.sleep(600);
            } catch (Exception ignored) {

            }
        }
    }

    public String getOverallConfiguration() {
        return  rom.toString()+"\n"+
                ram.toString()+"\n"+
                os.toString()+"\n"+
                processor.toString()+"\n"+
                monitor.toString()+"\n"+
                keyboard.toString()+"\n"+
                networkCard.toString()+"\n"+
                this;
    }

    public void print(String text) {
        this.monitor.display(text);
    }

    public void updateNetwork() {
        networkCard.toggleStatus();
    }

    @Override
    public String getInput() {
        if (keyboard != null) {
            return keyboard.getInput();
        }
        print("No Keyboard found.");
        return null;
    }
    public void startApplication(Application application, ApplicationInterface sys){
        Application app = ram.read(application);
        processor.runApp(app,sys);
    }
    public void deleteAppFromRam(){
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
