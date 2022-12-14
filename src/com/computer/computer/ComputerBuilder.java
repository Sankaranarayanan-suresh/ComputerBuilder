package com.computer.computer;

import com.computer.hardware.part.keyboard.Keyboard;
import com.computer.hardware.part.monitor.Monitor;
import com.computer.hardware.part.motherboard.MotherBoard;
import com.computer.hardware.part.networkcard.NetworkCard;
import com.computer.hardware.part.storage.RAM.RAM;
import com.computer.hardware.part.storage.ROM.ROM;
import com.computer.software.os.Os;
import com.computer.hardware.part.processor.Processor;
import com.computer.hardware.part.storage.ROM.ROM;

import java.lang.reflect.Field;

public class ComputerBuilder {
    private Monitor monitor;
    private Keyboard keyboard;
    private final MotherBoard motherBoard;
    private NetworkCard NetworkCard;
    private final Os os;
    private final RAM ram;
    private final ROM ROM;
    private final Processor processor;

    public ComputerBuilder(MotherBoard motherBoard, Os os, ROM ROM, RAM ram, Processor processor) {
        this.ROM = ROM;
        this.os = os;
        this.motherBoard = motherBoard;
        this.ram = ram;
        this.processor = processor;
    }

    public ComputerBuilder setMonitor(Monitor monitor) {
        this.monitor = monitor;
        return this;
    }

    public ComputerBuilder setNetworkCard(NetworkCard networkCard) {
        this.NetworkCard = networkCard;
        return this;
    }

    public ComputerBuilder setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
        return this;
    }

    public Computer build() {
        for (Field field : this.getClass().getDeclaredFields()) {
            Object part;
            try {
                part = field.get(this);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            if (part == null)
                continue;
            this.motherBoard.addPart((ComputerParts) part);
        }
        return new Computer(monitor, keyboard, motherBoard, NetworkCard, os, ROM, ram, processor);


//        if(monitor != null && keyboard != null && motherBoard != null){
//            this.motherBoard.addPart(monitor);
//            this.motherBoard.addPart(keyboard);
//            return new Computer(monitor, keyboard, motherBoard);
//        }
//        else {
//            return null;
//        }
    }
}
